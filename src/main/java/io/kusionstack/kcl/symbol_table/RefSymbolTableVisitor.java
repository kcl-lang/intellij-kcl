/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import io.kusionstack.kcl.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author amyxia
 * @version RefSymbolTableVisitor: RefSymbolTableVisitor.java, v 0.1 2021年05月31日 3:39 下午 amyxia Exp $
 */
public class RefSymbolTableVisitor extends KCLVisitor {
    private final SymbolTable symbolTable;
    private       Scope       currentScope;

    public RefSymbolTableVisitor(@NotNull SymbolTable st) {
        symbolTable = st;
        this.currentScope = st.globalScope;
    }

    public void startVisit(@NotNull KCLFile root) {
        visitElement(root);
    }

    @Override
    public void visitSchemaStmt(@NotNull KCLSchemaStmt o) {
        Symbol s = symbolTable.searchDef(o.getNameIdentifier());
        if (s instanceof SchemaSymbol) {
            // visit parent schema operand identifier
            if (o.getIdentifierList().size() == 1) {
                visitIdentifier(o.getIdentifierList().get(0));
            }
            // visit schema arguments
            if (o.getSchemaArguments() != null) {
                visitSchemaArguments(o.getSchemaArguments());
            }
            // visit schema body
            if (o.getSchemaBody() != null) {
                currentScope = (SchemaSymbol) s;
                visitSchemaBody(o.getSchemaBody());
                currentScope = currentScope.getEnclosingScope();
            }
        }
    }

    @Override
    public void visitSingleName(@NotNull KCLSingleName o) {
        if (symbolTable.searchDef(o) != null) {
            // this is a def
            return;
        }
        List<Symbol> s = currentScope.resolve(o.getName());
        if (s != null) {
            symbolTable.recordRefSymbols(o, s);
        }
    }

    @Override
    public void visitAssignStmt(@NotNull KCLAssignStmt o) {
        super.visitAssignStmt(o);
        // todo: if the target is a def, infer its type be infer the test expr's type
    }

    @Override
    public void visitIdentifier(@NotNull KCLIdentifier o) {
        if (o.getSingleNameList().size() == 1) {
            // this identifier is defined in current scope, without "pkg." prefix.
            List<Symbol> symbols = currentScope.resolve(o.getSingleNameList().get(0).getName());
            if (symbols != null) {
                symbolTable.recordRefSymbols(o.getSingleNameList().get(0), symbols);
            }
        }
        if (o.getSingleNameList().size() > 1) {
            // the pkg.identifier is: pkg.identifier or name.attr
            KCLSingleName outerNode = o.getSingleNameList().get(0);
            KCLSingleName firstInnerNode = o.getSingleNameList().get(1);
            List<Symbol> symbols = currentScope.resolve(outerNode.getName());
            if (symbols == null) {
                return;
            }
            // 有可能是 package.name.xx
            if (symbols.size() == 1 && symbols.get(0) instanceof PkgSymbol) {
                // 如果 outerNode 是 package
                PkgSymbol p = (PkgSymbol) symbols.get(0);
                symbolTable.recordRefSymbol(outerNode, p);
                List<Symbol> identifiers = p.getMembers().get(firstInnerNode.getName());
                if (identifiers != null) {
                    symbolTable.recordRefSymbols(firstInnerNode, identifiers);
                }
                return;
            }
            // 也有可能是 name.attr.xx, todo
        }
    }

    @Override
    public void visitMixinStmt(@NotNull KCLMixinStmt o) {
        // mixin stmt is actually in global scope
        SchemaSymbol schemaScope = (SchemaSymbol) currentScope;
        currentScope = schemaScope.getEnclosingScope();
        visitElement(o);
        currentScope = schemaScope;
    }

    @Override
    public void visitType(@NotNull KCLType o) {
        if (PsiTreeUtil.getParentOfType(o, KCLSchemaBody.class) != null) {
            Scope oldScope = currentScope;
            // if the type ref is in schema scope, we need to resolve it in the outer scope.
            while (!(currentScope instanceof GlobalScope)) {
                SchemaSymbol schemaScope = (SchemaSymbol) oldScope;
                currentScope = schemaScope.getEnclosingScope();
            }
            for (KCLTypeElement typeElement : o.getTypeElementList()) {
                visitTypeElement(typeElement);
            }
            currentScope = oldScope;
        } else {
            for (KCLTypeElement typeElement : o.getTypeElementList()) {
                visitTypeElement(typeElement);
            }
        }
    }

    @Override
    public void visitElement(@NotNull KCLElement o) {
        for (PsiElement element : o.getChildren()) {
            element.accept(this);
        }
    }
}
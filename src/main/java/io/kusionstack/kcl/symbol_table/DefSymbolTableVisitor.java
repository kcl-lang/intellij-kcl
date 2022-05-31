/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.symbol_table;

import io.kusionstack.kcl.KCLUtil;
import io.kusionstack.kcl.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileSystemItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author amyxia
 * @version KCLSymbolTableVisitor: KCLSymbolTableVisitor.java, v 0.1 2021年01月07日 11:30 下午 amyxia Exp $
 */
public class DefSymbolTableVisitor extends KCLVisitor {
    private final SymbolTable symbolTable;
    private       Scope       currentScope;

    public DefSymbolTableVisitor(@NotNull SymbolTable st) {
        symbolTable = st;
        this.currentScope = st.globalScope;
    }

    public void startVisit(@NotNull KCLFile root) {
        visitElement(root);
    }

    @Override
    public void visitImportStmt(@NotNull KCLImportStmt o) {
        KCLDotName importPath = o.getDotName();
        if (importPath == null) {
            return;
        }

        PsiFileSystemItem resolvedModule = KCLUtil.resolvePkg(importPath, o.getContainingFile());
        List<KCLSingleName> importPaths = importPath.getIdentifier().getSingleNameList();
        if (resolvedModule == null) {
            return;
        }
        if (o.getSingleName() != null) {
            KCLSingleName asName = o.getSingleName();
            PkgSymbol p = new PkgSymbol(asName.getName(), currentScope, o.getSingleName(), resolvedModule);
            symbolTable.recordPkg(resolvedModule, p);
            currentScope.define(p);
        } else {
            KCLSingleName leafPkg = importPaths.get(importPaths.size() - 1);
            assert leafPkg != null;
            PkgSymbol p = new PkgSymbol(leafPkg.getName(), currentScope, leafPkg, resolvedModule);
            symbolTable.recordPkg(resolvedModule, p);
            currentScope.define(p);
        }
    }

    /**
     * assign_stmt ::= target_primary ASSIGN (target_primary ASSIGN)* test | target_primary augassign test
     *
     * @param o assign_stmt node
     */
    @Override
    public void visitAssignStmt(@NotNull KCLAssignStmt o) {
        List<KCLIdentifier> targets = o.getIdentifierList();
        for (KCLIdentifier target : targets) {
            if (target.getSingleNameList().size() != 1) {
                // if the target primary is not an identifier, but a pkg.identifier, that means no new variable will be created
                //i.e. do not need to add new symbol to symbol table.
                break;
            }
            KCLSingleName targetIdentifier = target.getSingleNameList().get(0);
            String targetName = targetIdentifier.getName();
            if (targetName.startsWith("_") && currentScope.resolve(targetName) != null) {
                // if the target is a non-extracted variable, and has been defined before, ignore it.
                break;
            }
            // todo when resolve this symbol, first infer the type of it.
            Symbol symbol = new VariableSymbol(targetName, null, targetIdentifier);
            currentScope.define(symbol);
            symbolTable.recordDefSymbol(targetIdentifier, symbol);
        }
    }

    @Override
    public void visitSchemaStmt(@NotNull KCLSchemaStmt o) {
        // define schema symbol in current scope
        List<KCLIdentifier> parents = o.getIdentifierList();
        KCLIdentifier parent = parents.size() == 1 ? parents.get(0) : null;
        SchemaSymbol schema = new SchemaSymbol(o.getName(), currentScope, parent, o.getSingleName());
        currentScope.define(schema);
        // enter schema scope
        currentScope = schema;
        // record symbol to symbol table
        this.symbolTable.recordDefSymbol(o.getNameIdentifier(), schema);

        // define schema attributes:
        // each variable in the schema:
        // 1. if without a "_" prefix, is a public attribute of the schema
        // 2. if with a "_" prefix, is a private attribute of the schema
        KCLSchemaBody schemaBody = o.getSchemaBody();
        if (schemaBody != null) {
            List<KCLSchemaAttributeStmt> attrStmts = schemaBody.getSchemaAttributeStmtList();
            for (KCLSchemaAttributeStmt attr : attrStmts) {
                Symbol s = new Symbol(attr.getAttributeStmt().getSingleName().getName(), attr.getAttributeStmt().getSingleName());
                schema.define(s);
                symbolTable.recordDefSymbol(attr.getAttributeStmt().getSingleName(), s);
            }

            for (KCLSchemaIndexSignature indexSignature : schemaBody.getSchemaIndexSignatureList()) {
                KCLSingleName signatureName = indexSignature.getSingleName();
                if (signatureName != null) {
                    String indexName = signatureName.getName();
                    Symbol s = new Symbol(indexName, signatureName);
                    schema.define(s);
                    symbolTable.recordDefSymbol(signatureName, s);
                }
            }

            for (KCLSchemaInitStmt schemaStmt : schemaBody.getSchemaInitStmtList()) {
                this.visitElement(schemaStmt);
            }


        }
        // exit schema scope
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void visitElement(@NotNull KCLElement o) {
        for (PsiElement element : o.getChildren()) {
            element.accept(this);
        }
    }
}
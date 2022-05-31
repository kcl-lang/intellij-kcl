/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.psi;

import io.kusionstack.kcl.KCLUtil;
import io.kusionstack.kcl.symbol_table.Symbol;
import io.kusionstack.kcl.symbol_table.SymbolTable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author amyxia
 * @version KCLReference: KCLReference.java, v 0.1 2020年12月28日 2:59 下午 amyxia Exp $
 */
public class KCLNameReference extends PsiReferenceBase<KCLSingleName> implements PsiPolyVariantReference {

    /**
     * create a KCLReference instance for the selected element
     *
     * @param element the selected element
     */
    public KCLNameReference(@NotNull KCLSingleName element) {
        super(element);
    }

    @Override
    public @NotNull ResolveResult[] multiResolve(boolean incompleteCode) {
        // for name in import path, resolve import module:
        PsiElement parent = myElement.getParent();

        if (parent instanceof KCLIdentifier) {
            PsiElement superParent = parent.getParent();
            if (superParent instanceof KCLDotName) {
                PsiFileSystemItem result = KCLUtil.resolvePkg((KCLDotName) superParent, myElement.getContainingFile(),
                        ((KCLIdentifier) parent).getSingleNameList().indexOf(myElement));
                return wrapResult(result);
            }
        }
        // for other names: the name must be in the symbol table
        KCLFile mainFile = (KCLFile) myElement.getContainingFile();
        SymbolTable symbolTable = KCLUtil.buildSymbolTable(mainFile);
        return wrapResult(symbolTable.searchSymbol(myElement));
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    /**
     * @return the range of text within the selected element. the text usually means the name of the element.
     */
    @Override
    public @NotNull TextRange getRangeInElement() {
        return TextRange.create(0, myElement.getTextRange().getLength());
    }

    private ResolveResult[] wrapResult(List<Symbol> symbols) {
        if (symbols == null) {
            return new ResolveResult[] {};
        }
        return symbols.stream().map(symbol -> new PsiElementResolveResult(symbol.getNode())).collect(Collectors.toList()).toArray(
                new ResolveResult[symbols.size()]);
    }

    private ResolveResult[] wrapResult(PsiFileSystemItem item) {
        if (item == null) {
            return new ResolveResult[] {};
        }
        return new ResolveResult[] {new PsiElementResolveResult(item)};
    }
}
/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.psi.KCLTypes;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author amyxia
 * @version KCLBraceMatcher: KCLBraceMatcher.java, v 0.1 2021年04月28日 1:36 下午 amyxia Exp $
 */
public class KCLBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(KCLTypes.LEFT_BRACE, KCLTypes.RIGHT_BRACE, true),
            new BracePair(KCLTypes.LEFT_PARENTHESES, KCLTypes.RIGHT_PARENTHESES, false),
            new BracePair(KCLTypes.LEFT_BRACKETS, KCLTypes.RIGHT_BRACKETS, false)
    };

    @Override
    public @NotNull BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
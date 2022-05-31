/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.completion;

import io.kusionstack.kcl.completion.keyword.AsKeywordProvider;
import io.kusionstack.kcl.completion.keyword.RelaxedKeywordProvider;
import io.kusionstack.kcl.completion.keyword.TypeNameProvider;
import io.kusionstack.kcl.psi.KCLImportStmt;
import io.kusionstack.kcl.psi.KCLTypeElement;
import io.kusionstack.kcl.psi.KCLTypes;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.ElementPattern;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;

import static com.intellij.patterns.PlatformPatterns.psiElement;

/**
 * @author amyxia
 * @version KCLCompletionContributor: KCLCompletionContributor.java, v 0.1 2020年09月23日 4:52 下午 amyxia Exp $
 */
public class KCLCompletionContributor extends CompletionContributor {
    public KCLCompletionContributor() {
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement(KCLTypes.NAME),
                new KeywordProvider()
        );

        extend(
                CompletionType.BASIC,
                importName(),
                new ImportNameProvider()
        );

        extend(
                CompletionType.BASIC,
                importDot(),
                new ImportNameProvider()
        );
        extend(
                CompletionType.BASIC,
                afterSchemaKeyword(),
                new RelaxedKeywordProvider()
        );
        extend(
                CompletionType.BASIC,
                importAs(),
                new AsKeywordProvider()
        );
        extend(
                CompletionType.BASIC,
                typeName(),
                new TypeNameProvider()
        );
    }

    private static ElementPattern<PsiElement> importName() {
        return psiElement(KCLTypes.NAME)
                .withSuperParent(4, psiElement(KCLImportStmt.class));
    }

    private static ElementPattern<PsiElement> importDot() {
        return psiElement(KCLTypes.DOT)
                .withSuperParent(4, psiElement(KCLImportStmt.class));
    }

    private static ElementPattern<PsiElement> importAs() {
        return psiElement(KCLTypes.NAME).withParent(psiElement(PsiErrorElement.class)).withSuperParent(2, KCLImportStmt.class);
    }

    private static ElementPattern<PsiElement> afterSchemaKeyword() {
        return psiElement(KCLTypes.NAME).afterLeaf(psiElement(KCLTypes.SCHEMA));
    }

    private static ElementPattern<PsiElement> typeName() {
        return psiElement(KCLTypes.NAME).withSuperParent(3, KCLTypeElement.class);
    }
}
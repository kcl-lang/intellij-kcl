/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.completion;

import io.kusionstack.kcl.psi.*;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version KeywordProvider: KeywordProvider.java, v 0.1 2020年12月17日 5:17 下午 amyxia Exp $
 */
public class KeywordProvider extends CompletionProvider<CompletionParameters> {
    private static final String IMPORT = "import";
    private static final String SCHEMA = "schema";
    private static final String CHECK  = "check";
    private static final String MIXIN  = "mixin";
    private static final String FINAL  = "final";
    private static final String IF     = "if";
    private static final String ELIF   = "elif";
    private static final String ELSE   = "else";
    private static final String TRUE   = "True";
    private static final String FALSE  = "False";
    private static final String NONE   = "None";
    private static final String ASSERT = "assert";

    // ** 解决
    // -- 不够完整
    // ++ 不够严格

    // Special tokens:
    // "import", "as", "schema", "mixin", "relaxed", "check", "for", "assert", "if", "elif", "else", "or", "and", "not", "in", "is",
    // "final", "lambda",
    // ** import: 前面没有任何stmt，或只有import stmt
    // ** as: 前面只有不带as name的import stmt
    // ++ schema: 必须位于行首，严格的【顶格】行首（不能是省略了indent的NEWLINE）todo:不能在list/dict结构的内部，意味着除了NEWLINE外的上一个节点是个完整stmt
    // ** relaxed：紧跟 schema 关键字之后

    // ** mixin：处于schema stmt内部，并且位于行首，不需要顶格，并且前面只能有schema Header 和 docstring
    // ** check：位于schema stmt内部，并且位于行首，不需要顶格，并且后面不能有任何schema的内容

    // for：必须位于dict/list comp之内
    // ++ assert：位于行首，但不需要是顶格的行首 todo: 不能在list/dict结构的内部，可以在schema内
    // if, elif, else
    // elif 和 else 只有上一句是if 时，才提示elif和else
    // or and not in is
    // final 位于schema body内，前面不能有check，后面不能有mixin stmt
    // lambda

    // types:
    // ** str bool int float：必须在type element内

    // Constant tokens
    // "True", "False", "None"

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet result) {
        String text = result.getPrefixMatcher().getPrefix();
        if ("".equals(text)) {
            return;
        }

        PsiElement current = parameters.getPosition();

        LeafPsiElement prevLeaf = (LeafPsiElement) PsiTreeUtil.prevLeaf(current);

        boolean atFileStart = prevLeaf == null;
        boolean atLineStartStrict = atFileStart || (prevLeaf.getElementType() == KCLTypes.NEWLINE && prevLeaf.getText().endsWith(
                "\n")); // 顶格的行首
        boolean atLineStartLoose = atFileStart || prevLeaf.getElementType() == KCLTypes.NEWLINE; // 不一定顶格的行首
        boolean inSchemaBody = PsiTreeUtil.getParentOfType(current, KCLSchemaBody.class) != null;

        if (atLineStartStrict) {
            addKeywords(result, new String[] {SCHEMA, IF, ASSERT, TRUE, FALSE, NONE});
        }

        if (atFileStart) {
            addKeywords(result, new String[] {IMPORT});
        }

        if (!atFileStart && atLineStartLoose) {
            PsiElement prevLineNode = prevLeaf.getPrevSibling();
            if (prevLineNode instanceof KCLImportStmt) {
                // only after import stmt
                addKeyword(result, IMPORT);
            }

            // inside of schema body:
            // mixin, check, final
            if (inSchemaBody) {
                KCLStatement currentStmt = PsiTreeUtil.getParentOfType(current, KCLStatement.class);
                if (currentStmt != null) {
                    if (currentStmt.getNextSibling() == null) {
                        addKeyword(result, CHECK);
                    }
                    boolean atSchemaBodyStart = true;
                    PsiElement prevSibling = currentStmt.getPrevSibling();
                    while (prevSibling != null) {
                        if (prevSibling instanceof KCLSchemaAttributeStmt || prevSibling instanceof KCLStatement) {
                            atSchemaBodyStart = false;
                            break;
                        }
                        prevSibling = prevSibling.getPrevSibling();
                    }
                    if (atSchemaBodyStart) {
                        addKeyword(result, MIXIN);
                    }

                    addKeywords(result, new String[] {FINAL, IF, ASSERT, TRUE, FALSE, NONE});
                }
            }

            addKeywords(result, new String[] {ELIF, ELSE});
        }
    }

    private void addKeywords(CompletionResultSet result, String[] candidateKeywords) {
        for (String kw : candidateKeywords) {
            result.addElement(LookupElementBuilder.create(kw));
        }
    }

    private void addKeyword(CompletionResultSet result, String keyword) {
        result.addElement(LookupElementBuilder.create(keyword));
    }
}

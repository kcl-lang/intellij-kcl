/**
 * KusionStack. Copyright (c) 2020-2021 All Rights Reserved.
 */
package io.kusionstack.kcl.completion.keyword;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version TypeNameKeywordProvider: TypeNameKeywordProvider.java, v 0.1 2021年02月23日 3:18 下午 amyxia Exp $
 */
public class TypeNameProvider extends CompletionProvider<CompletionParameters> {
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet result) {
        result.addElement(LookupElementBuilder.create("str"));
        result.addElement(LookupElementBuilder.create("int"));
        result.addElement(LookupElementBuilder.create("float"));
        result.addElement(LookupElementBuilder.create("bool"));
        result.addElement(LookupElementBuilder.create("any"));
        result.addElement(LookupElementBuilder.create("True"));
        result.addElement(LookupElementBuilder.create("False"));
        result.addElement(LookupElementBuilder.create("None"));
    }
}
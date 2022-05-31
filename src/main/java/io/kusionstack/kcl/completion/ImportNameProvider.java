/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.completion;

import io.kusionstack.kcl.KCLUtil;
import io.kusionstack.kcl.psi.KCLDotName;
import io.kusionstack.kcl.psi.KCLFile;
import io.kusionstack.kcl.psi.KCLLeadingDots;
import io.kusionstack.kcl.psi.KCLSingleName;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author amyxia
 * @version ImportNameProvider: ImportNameProvider.java, v 0.1 2020年12月17日 4:46 下午 amyxia Exp $
 */
public class ImportNameProvider extends CompletionProvider<CompletionParameters> {
    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet result) {
        KCLDotName dottedName = PsiTreeUtil.getContextOfType(parameters.getPosition(), KCLDotName.class);
        if (dottedName == null) {
            return;
        }
        PsiElement prev = dottedName.getPrevSibling();
        int leadingDotCount = 0;
        if (prev instanceof KCLLeadingDots) {
            leadingDotCount = prev.getTextLength();
        }

        List<KCLSingleName> existPaths = dottedName.getIdentifier().getSingleNameList();
        List<String> paths = Lists.newArrayList();
        for (KCLSingleName n : existPaths) {
            paths.add(n.getName());
        }
        String lastName = result.getPrefixMatcher().getPrefix();
        boolean endDot = lastName.length() == 0;
        if (endDot) {
            paths.remove(paths.size() - 1);
        } else {
            paths.set(paths.size() - 1, lastName);
        }

        // 当前文件位置
        // 找到 kcl.mod 文件位置，这个位置就是根目录
        // 第一个可以引用的包名是：当前目录下的文件名、根目录下的所有目录、文件名
        // 除第一个以后，可以引用的包名：根据已经引用的包名来计算
        PsiFile containingFile = parameters.getOriginalFile();

        PsiDirectory importDir = containingFile.getContainingDirectory();
        PsiDirectory current = containingFile.getContainingDirectory();

        for (int i = 0; i < leadingDotCount - 1; i++) {
            importDir = importDir.getParentDirectory();
            if (importDir == null) {
                return;
            }
        }

        if (paths.isEmpty()) {
            // 除了开头的点之外，没别的内容了
            addImportElementFromPsiBatch(importDir, result, containingFile);
        } else {
            // 最后一级刚好是"点" or 最后一级是name半成品
            completeLastImportName(containingFile, importDir, paths, result, endDot);
        }
        if (leadingDotCount == 0) {
            completeLastImportName(containingFile, KCLUtil.findKCLRoot(current), paths, result, endDot);
        }
    }

    private void completeLastImportName(@NotNull PsiFile currentFile, @NotNull PsiDirectory root, List<String> paths,
                                        CompletionResultSet result,
                                        boolean endingDot) {
        for (int i = 0; i < paths.size() - (endingDot ? 0 : 1); i++) {
            PsiDirectory sub = root.findSubdirectory(paths.get(i));
            if (sub == null) {
                return;
            }
            root = sub;
        }
        addImportElementFromPsiBatch(root, result, currentFile);
    }

    private void addImportElementFromPsiBatch(PsiDirectory dir, CompletionResultSet result, PsiFile currentFile) {
        Set<PsiDirectory> subDirs = Arrays.stream(dir.getSubdirectories()).filter(
                d -> KCLUtil.containsKclFile(d, true)
        ).collect(Collectors.toSet());
        Set<PsiFile> subFiles = Arrays.stream(dir.getFiles()).filter(
                e -> e instanceof KCLFile && !e.equals(currentFile)
        ).collect(Collectors.toSet());

        for (PsiDirectory d : subDirs) {
            result.addElement(LookupElementBuilder.create(d.getName()));
        }
        for (PsiFile f : subFiles) {
            result.addElement(LookupElementBuilder.create(((KCLFile) f).getSimpleName()));
        }
    }

}
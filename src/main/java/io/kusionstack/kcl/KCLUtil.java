/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import io.kusionstack.kcl.psi.KCLDotName;
import io.kusionstack.kcl.psi.KCLFile;
import io.kusionstack.kcl.psi.KCLSingleName;
import io.kusionstack.kcl.symbol_table.DefSymbolTableVisitor;
import io.kusionstack.kcl.symbol_table.RefSymbolTableVisitor;
import io.kusionstack.kcl.symbol_table.SymbolTable;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileSystemItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author amyxia
 * @version KCLUtil: KCLUtil.java, v 0.1 2020年09月23日 11:52 上午 amyxia Exp $
 */
public class KCLUtil {
    private static final String KCL_MOD_FILE = "kcl.mod";

    public static PsiDirectory findKCLRoot(PsiDirectory dir) {
        while (dir != null) {
            if (dir.findFile(KCL_MOD_FILE) != null) {
                return dir;
            }
            dir = dir.getParentDirectory();
        }
        return null;
    }

    public static SymbolTable buildSymbolTable(KCLFile file) {
        SymbolTable st = new SymbolTable();
        DefSymbolTableVisitor defVisitor = new DefSymbolTableVisitor(st);
        defVisitor.startVisit(file);
        RefSymbolTableVisitor refVisitor = new RefSymbolTableVisitor(st);
        refVisitor.startVisit(file);
        return st;
    }

    public static boolean containsKclFile(PsiDirectory dir, boolean recursive) {
        for (PsiFile file : dir.getFiles()) {
            if (file instanceof KCLFile) {
                return true;
            }
        }
        if (recursive) {
            for (PsiDirectory subDir : dir.getSubdirectories()) {
                if (containsKclFile(subDir, recursive)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static @Nullable PsiFileSystemItem resolvePkg(KCLDotName originalPath, PsiFile currentFile) {
        List<KCLSingleName> importPaths = originalPath.getIdentifier().getSingleNameList();
        return resolvePkg(originalPath, currentFile, importPaths.size() - 1);
    }

    public static @Nullable PsiFileSystemItem resolvePkg(KCLDotName originalPath, PsiFile currentFile, int targetIndex) {
        if (targetIndex < 0) {
            return null;
        }
        int leadingDot = originalPath.getLeadingDots() == null ? 0 : originalPath.getLeadingDots().getTextLength();
        List<KCLSingleName> importPaths = originalPath.getIdentifier().getSingleNameList();
        if (importPaths.size() == 0) {
            return null;
        }
        PsiDirectory currentDir = currentFile.getContainingDirectory();

        if (leadingDot == 0) {
            // 如果 import path 中不包含 leading dot，则优先按照绝对路径进行解析
            PsiDirectory kclRoot = findKCLRoot(currentDir);
            if (kclRoot == null) {
                return null;
            }
            PsiFileSystemItem matched = getMatchedModule(kclRoot, importPaths.get(0).getName());
            if (matched != null) {
                currentDir = kclRoot;
            }
        }
        // 识别 leading dot，并定位到顶层路径
        for (int i = leadingDot - 1; i > 0; i--) {
            currentDir = currentDir.getParentDirectory();
            if (currentDir == null) {
                return null;
            }
        }
        int index = 0;
        while (index <= targetIndex) {
            KCLSingleName path = importPaths.get(index);
            PsiFileSystemItem matched = getMatchedModule(currentDir, path.getName());
            // not matched:
            if (matched == null) {
                return null;
            }
            // matched, and reached the target index
            if (index == targetIndex) {
                return matched;
            }
            // matched, but didn't reach the target index
            // if matched is not directory:
            if (!(matched instanceof PsiDirectory)) {
                return null;
            }
            // if matched is directory:
            currentDir = (PsiDirectory) matched;
            index++;
        }
        return null;
    }

    private static PsiFileSystemItem getMatchedModule(PsiDirectory current, String name) {
        // 优先检查子目录
        PsiDirectory dir = current.findSubdirectory(name);
        if (dir != null) {
            return dir;
        }
        // 其次检查子文件
        PsiFile f = current.findFile(name + "." + KCLFileType.INSTANCE.getDefaultExtension());
        return f;
    }
}
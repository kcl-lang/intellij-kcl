/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.psi;

import io.kusionstack.kcl.KCLFileType;
import io.kusionstack.kcl.KCLLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version KCLFile: KCLFile.java, v 0.1 2020年09月23日 10:26 上午 amyxia Exp $
 */
public class KCLFile extends PsiFileBase implements KCLScopeOwner, KCLNamedElement {
    public KCLFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, KCLLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return KCLFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "KCL File";
    }

    public @NotNull String getSimpleName() {
        String fullName = super.getName();
        return fullName.substring(0, fullName.length() - 2);
    }

    @Override
    public @NotNull PsiElement getNameIdentifier() {
        return this;
    }
}
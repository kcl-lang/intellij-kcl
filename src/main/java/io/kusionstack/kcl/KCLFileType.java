/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author amyxia
 * @version KCLFileType: KCLFileTyoe.java, v 0.1 2020年09月21日 10:04 下午 amyxia Exp $
 */
public final class KCLFileType extends LanguageFileType {
    public static final KCLFileType INSTANCE = new KCLFileType();

    private KCLFileType() {
        super(KCLLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "KCL File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "KCL language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "k";
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return KCLIcons.FILE;
    }
}
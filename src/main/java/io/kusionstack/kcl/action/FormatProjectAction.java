/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.action;

import io.kusionstack.kcl.util.KCLBinaryUtil;
import io.kusionstack.kcl.util.KCLFmtCommand;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version FormatProjectAction: FormatProjectAction.java, v 0.1 2020年11月30日 5:09 下午 amyxia Exp $
 */
public class FormatProjectAction extends DumbAwareAction {
    @Override
    public void update(@NotNull AnActionEvent e) {
        // the action button is always visible
        e.getPresentation().setVisible(true);
        // the action button is enabled only when kcl is installed
        e.getPresentation().setEnabled(KCLBinaryUtil.KCLInstalled());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        assert project != null;
        // save all documents before formatting
        FileDocumentManager.getInstance().saveAllDocuments();

        for (Module module : ModuleManager.getInstance(project).getModules()) {
            for (VirtualFile file : ModuleRootManager.getInstance(module).getContentRoots()) {
                KCLFmtCommand.execute(file);
                VfsUtil.markDirtyAndRefresh(true, true, true, file);
            }
        }
    }
}
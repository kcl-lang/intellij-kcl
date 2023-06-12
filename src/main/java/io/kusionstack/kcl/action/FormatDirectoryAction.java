/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.action;

import io.kusionstack.kcl.util.KCLBinaryUtil;
import io.kusionstack.kcl.util.KCLFmtCommand;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version FormatDirectoryAction: FormatDirectoryAction.java, v 0.1 2020年12月03日 2:48 下午 amyxia Exp $
 */
public class FormatDirectoryAction extends DumbAwareAction {
    @Override
    public void update(@NotNull AnActionEvent e) {
        // Using the event, evaluate the context, and enable or disable the action.
        // the action button is visible only when the current focused item is a file directory
        VirtualFile vf = e.getData(CommonDataKeys.VIRTUAL_FILE);
        e.getPresentation().setVisible((vf != null && vf.isDirectory()));
        // the action button is enabled only when kcl is installed
        e.getPresentation().setEnabled(KCLBinaryUtil.KCLFmtCmdInstalled());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        assert project != null;
        // save all documents before formatting
        FileDocumentManager.getInstance().saveAllDocuments();
        // do kcl fmt
        VirtualFile file = e.getRequiredData(CommonDataKeys.VIRTUAL_FILE);
        KCLFmtCommand.execute(file);
        VfsUtil.markDirtyAndRefresh(true, true, true, file);
    }
}
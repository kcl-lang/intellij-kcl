/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.action;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import io.kusionstack.kcl.KCLFileType;
import io.kusionstack.kcl.util.KCLBinaryUtil;
import io.kusionstack.kcl.util.KCLFmtCommand;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version FormatSingleFileAction: FormatSingleFileAction.java, v 0.1 2020年11月04日 10:00 下午 amyxia Exp $
 */
public class FormatSingleFileAction extends AnAction {
    @Override
    public void update(@NotNull AnActionEvent e) {
        // Using the event, evaluate the context, and enable or disable the action.
        // the action button is visible only when the current file is a kcl file
        VirtualFile vf = e.getData(CommonDataKeys.VIRTUAL_FILE);
        e.getPresentation().setVisible((vf != null && isKCLFile(vf)));
        // the action button is enabled only when kcl is installed
        e.getPresentation().setEnabled(KCLBinaryUtil.KCLFmtCmdInstalled());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getProject();
        assert project != null;
        VirtualFile file = event.getRequiredData(CommonDataKeys.VIRTUAL_FILE);
        Document document = FileDocumentManager.getInstance().getDocument(file);
        if (document != null) {
            FileDocumentManager.getInstance().saveDocument(document);
        } else {
            FileDocumentManager.getInstance().saveAllDocuments();
        }

        // execute kcl --fmt <filepath> command to get formatted content
        KCLFmtCommand.execute(file);
        VfsUtil.markDirtyAndRefresh(true, true, true, file);
    }

    public boolean isKCLFile(VirtualFile virtualFile) {
        if (virtualFile != null) {
            return (virtualFile.getFileType() instanceof KCLFileType);
        }
        return false;
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread(){
        return ActionUpdateThread.BGT;
    }
}
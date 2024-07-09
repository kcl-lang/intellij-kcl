/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.action;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAwareAction;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version OpenLinkAction: OpenLinkAction.java, v 0.1 2020年12月03日 3:19 下午 amyxia Exp $
 */
public abstract class OpenLinkAction extends DumbAwareAction {
    public abstract String getLink();

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        BrowserUtil.browse(getLink());
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }
}
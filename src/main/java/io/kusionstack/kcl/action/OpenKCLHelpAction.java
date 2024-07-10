/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.action;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import org.jetbrains.annotations.NotNull;

/**
 * @author amyxia
 * @version OpenKCLHelpAction: OpenKCLHelpAction.java, v 0.1 2020年12月03日 3:22 下午 amyxia Exp $
 */
public class OpenKCLHelpAction extends OpenLinkAction {
    @Override
    public String getLink() {
        return "https://kusionstack.io/docs/reference/lang/lang/tour";
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }
}
/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.util;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author amyxia
 * @version KCLFmtCommand: KCLFmtCommand.java, v 0.1 2020年12月03日 2:53 下午 amyxia Exp $
 */
public class KCLFmtCommand {
    private static final Logger LOGGER = Logger.getInstance(KCLFmtCommand.class);

    public static boolean execute(@NotNull VirtualFile virtualFile, boolean isDirectory) {
        String path = virtualFile.getCanonicalPath();
        LOGGER.info(String.format("path: %s", isDirectory));
        if (isDirectory){
            path = path.concat("...");
        }

        ExecuteResult result = KCLBinaryUtil.execKCLSubCmd("fmt", path);
        if (!result.isSuccess()) {
            LOGGER.error(String.format("kcl fmt %s exec failed, err msg: %s", virtualFile.getPath(), result.getStderr()));
        }
        return result.isSuccess();
    }
}
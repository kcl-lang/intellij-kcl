/**
 * KusionStack. Copyright (c) 2020-2020 All Rights Reserved.
 */
package io.kusionstack.kcl.util;

import com.google.common.base.Joiner;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.util.EnvironmentUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author amyxia
 * @version KCLBinaryUtil: KCLBinaryUtil.java, v 0.1 2020年11月05日 9:59 下午 amyxia Exp $
 */
public class KCLBinaryUtil {
    private static final Logger LOGGER = Logger.getInstance(KCLBinaryUtil.class);
    public static        String KCLLocation;
    public static final  String kclCmdName = "kcl";
    static {
        KCLInstalled();
    }

    public static boolean KCLInstalled() {
        return KCLCmdInstalled(kclCmdName);
    }

    public static boolean KCLCmdInstalled(String command) {
        String[] kclParentPaths = EnvironmentUtil.getValue("PATH").split(File.pathSeparator);
        for (String location :kclParentPaths) {
            File file = new File(Joiner.on(File.separator).join(location, command));
            if (file.exists()) {
                KCLLocation = file.getAbsolutePath();
                LOGGER.info(String.format("KCL command %s location: %s", command, KCLLocation));
                return true;
            }
        }
        return false;
    }
    public static ExecuteResult execKCLSubCmd(String subCommand, String... options) {
        if (!KCLInstalled()) {
            LOGGER.error(String.format("KCL command %s is not installed. Cannot execute.", subCommand));
            return ExecuteResult.KCLNotInstalled();
        }
        // assemble the KCL command from filePath & options
        String[] cmd = new String[2 + options.length];

        cmd[0] = KCLLocation;
        cmd[1] = subCommand;
        System.arraycopy(options, 0, cmd, 2, options.length);
        try {
            LOGGER.info(String.format("run cmd %s ", Arrays.toString(cmd)));
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            if (process.exitValue() == 0) {
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                // read the stdout from the command
                String stdout = stdInput.lines().collect(Collectors.joining(System.lineSeparator()));
                LOGGER.info(String.format("exec kcl cmd success, stdout: %s", stdout));
                return ExecuteResult.success(stdout);
            } else {
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                // read the stderr from the command
                String stderr = stdInput.lines().collect(Collectors.joining(System.lineSeparator()));
                LOGGER.error(String.format("exec kcl cmd failed, stderr: %s", stderr));
                return ExecuteResult.fail(stderr, process.exitValue());
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.error("exec kcl cmd failed.", e);
            return ExecuteResult.fail("unknown err", 1);
        }
    }

}
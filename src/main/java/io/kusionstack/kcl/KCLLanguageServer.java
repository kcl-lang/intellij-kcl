package io.kusionstack.kcl;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import com.intellij.util.EnvironmentUtil;
import com.redhat.devtools.lsp4ij.LanguageServerManager;
import com.redhat.devtools.lsp4ij.server.ProcessStreamConnectionProvider;

public class KCLLanguageServer extends ProcessStreamConnectionProvider {

    public KCLLanguageServer(Project project) {
        try {
            String kclLSPPath = findExecutableInPATH("kcl-language-server");
            super.setCommands(List.of(kclLSPPath));
        } catch (Exception e) {
            NotificationGroupManager.getInstance().getNotificationGroup("KCL LSP").createNotification(
                    "KCL LSP",
                    "KCL Language Server not found. Ensure it is installed properly (and is available in PATH), and restart the IDE. "
                            + "Note: A path containing a colon ':' may cause issues on some systems.",
                    NotificationType.ERROR
            ).notify(project);
            LanguageServerManager.getInstance(project).stop("KCLLanguageServerId");
        }
    }

    private String findExecutableInPATH(String executable) {
        // Get the system environment variables
        Map<String,String> envVariablesMap = EnvironmentUtil.getEnvironmentMap();
        // Check if the current operating system is Windows
        boolean isWindows  = System.getProperty("os.name").startsWith("Windows");
        // Append '.exe' to the executable name if on Windows, otherwise leave it as is
        String executableName = isWindows ? executable + ".exe" : executable;

        Optional<File> foundExecutable = Stream.of(envVariablesMap.get("PATH"))
                                               // Split the PATH by the platform-specific separator (':' for Unix, ';' for Windows)
                                               .flatMap(path -> Stream.of(path.split(File.pathSeparator)))
                                               .map(path -> Path.of(path,executableName).toFile())
                                               .filter(file -> file.exists() && file.canExecute())
                                               .findFirst();

        return foundExecutable.map(File::getPath).orElse(null);
    }

}

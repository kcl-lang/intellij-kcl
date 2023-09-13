package io.kusionstack.kcl;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.LspServerSupportProvider;
import org.jetbrains.annotations.NotNull;

public class KCLLspServerSupportProvider implements LspServerSupportProvider  {
    @Override
    public void fileOpened(@NotNull Project project, @NotNull VirtualFile file, @NotNull LspServerStarter serverStarter) {
        if (false == (file.getFileType() instanceof KCLFileType)) return;

        if (file.getExtension().equals(KCLFileType.INSTANCE.getDefaultExtension())) {
            KCLLspServerDescriptor kclLspServerDescriptor = new KCLLspServerDescriptor(project);
            serverStarter.ensureServerStarted(kclLspServerDescriptor);
        }
    }
}

package io.kusionstack.kcl;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor;
import org.jetbrains.annotations.NotNull;

public class KCLLspServerDescriptor extends ProjectWideLspServerDescriptor {
    public KCLLspServerDescriptor(@NotNull Project project) { super(project, "KCL"); }

    @Override
    public boolean isSupportedFile(@NotNull VirtualFile file) {
        return file != null && (file.getFileType() instanceof KCLFileType);
    }

    @Override
    public GeneralCommandLine createCommandLine() {
        GeneralCommandLine generalCommandLine = new GeneralCommandLine("kcl-language-server", "--stdio");
        return generalCommandLine;
    }
}

package io.kusionstack.kcl;

import java.util.List;

import com.redhat.devtools.lsp4ij.server.ProcessStreamConnectionProvider;

public class KCLLanguageServer extends ProcessStreamConnectionProvider {

    public KCLLanguageServer() {
        super.setCommands(List.of("kcl-language-server"));
    }

}

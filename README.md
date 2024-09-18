# KCL Plugin for IntelliJ IDEA
<!-- Plugin description -->

<!-- This specific section of `Plugin description` is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process. 
To keep everything working, do not remove `<!-- ... ->`
-->

The KCL IntelliJ IDEA plugin provides rich language support for the [KCL language](https://kcl-lang.io/).

<!-- Plugin description end -->
## Quick Start

Welcome to KCL developing! We hope this plugin enhances your development experience with KCL.

- **Step 1.** [Install KCL](https://kcl-lang.io/docs/user_docs/getting-started/install) on your system.

- **Step 2.** Install the KCL plugin for IntelliJ IDEA in Marketplace. Preference -> plugins -> Marketplace -> search `KCL` -> install -> restart IDE. This plugin requires the IntelliJ IDEA Ultimate 2023.2+

- **Step 3.** Open or create a KCL file and begin your KCL tour!

## Features

This extension provides many coding assistance based on Language Server Protocol.

+ **Highlight:** Syntax and semantic highlight
+ **Completion:** Completion for keywords, variable name, attributes and more
+ **Goto definition:** Goto definition of schema, variable, schema attribute, and import pkg
+ **Structure:** Main definition(schema def) and variables in KCL file
+ **Hover:** Identifier information (type and schema documentation)
+ **Diagnostics:** Warnings and errors in KCL file
+ **Code Action:** Quick fix for some errors
+ **InlayHint:** Hint for variable type, function and schema args

Other useful features such as diagnostics and testing are in developing.

## Ask for help

If the plugin isn't working as you expect, please reach out to us by filing an issue.


## Contributing

We are working actively on improving the KCL development on IntelliJ IDEA, and we welcome all kinds of contributions. You can refer to our [contribution guide](docs/CONTRIBUTING.md). It introduces how to build and run the extension locally.


## License

Apache License Version 2.0

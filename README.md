# KCL Plugin for IntelliJ IDEA

The KCL IntelliJ IDEA plugin provides rich language support for the [KCL language](https://kusionstack.io/docs/reference/lang/).


## Quick Start

Welcome to KCL developing! We hope this plugin enhances your development experience with KCL.

-   **Step 1.** Install kcl on your system. We highly recommend to [install the Kusion tools package](https://kusionstack.io/docs/user_docs/getting-started/install) which contains the KCL language support and other tools. 
-   **Step 2.** Install the KCL plugin for IntelliJ IDEA. Download the distribution from [here](distributions) and in IntelliJ IDEA, click Preference -> plugins -> install Plugin from Disk... -> select kcl-idea-plugin zip -> restart IDE. This plugin requires the IntelliJ IDEA Ultimate 2023.2+
-   **Step 3.** Open or create a KCL file and begin your KCL tour!

<div style="text-align: center;"><img src="docs/img/how-to-install.gif" alt="IntelliJ KCL Plugin install"></div>

## Features

This extension provides coding assistance such as basic syntax highlight, IntelliSense such as auto complete, and some basic code navigation. Other useful features such as diagnostics and testing are in developing.

### Highlight
<div style="text-align: center;"><img src="docs/img/highlight.jpg" alt="highlight"></div>

### Code Formatting

Right click on the editor and select KCL Tools -> Format File to format current KCL file:

<div style="text-align: center;"><img src="docs/img/format-file.png" alt="format file"></div>

Right click on the target directory in the project structure panel, select KCL Tools -> Format Directory to format all files under the selected folder:

<div style="text-align: center;"><img src="docs/img/format-directory.png" alt="format directory"></div>

Right click on the project name in the project structure panel, select KCL Tools -> Format Project to format all files in the project:

<div style="text-align: center;"><img src="docs/img/format-project.png" alt="format project"></div>


## Ask for help

If the plugin isn't working as you expect, please reach out to us by filing an issue.


## Contributing

We are working actively on improving the KCL development on IntelliJ IDEA, and we welcome all kinds of contributions. You can refer to our [contribution guide](docs/CONTRIBUTING.md). It introduces how to build and run the extension locally.


## License

Apache License Version 2.0

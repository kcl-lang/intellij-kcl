# The KCL IDE Plugin

- code repo: https://github.com/KusionStack/intellij-kcl

## Prerequisites

1. Install JDK 1.8 +
2. Download IntelliJ IDEA Ultimate 2023.2+
3. Make sure the bundled *Plugin DevKit* plugin is enabled. Install and enable *Grammar-Kit* and *PsiViewer* plugins.

## How To Build

```
$ ./gradlew build
```

## How To Run

```
$ ./gradlew runIde
```

It will launch a new IDE environment, in which you can create a project and add .k file to play with.

![run sample](./docs/img/how-to-run-1.png)

## Reference

- [Custom Language Support](https://jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support.html)
- [Custom Language Support Tutorial](https://jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support_tutorial.html)
- [Testing a Custom Language Plugin](https://jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html)
- [Language Server Protocol for Plugin Developers](https://blog.jetbrains.com/platform/2023/07/lsp-for-plugin-developers/)


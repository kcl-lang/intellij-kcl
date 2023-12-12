## Environment Requirements

- Install IntelliJ IDEA (does not necessarily need to match the target IDE version of the plugin)
- JDK11 and JDK17
- the Gradle Intellij Plugin (latest version)
- Encoding settings: set Default encoding for properties files in IntelliJ IDEA > Preference > File Encoding > Properties files(*.properties) to UTF-8

## Terminology

- the `intellij-kcl` plugin: This project
- Gradle Intellij Plugin: A Gradle IDE plugin that provides integration for compiling and building Gradle projects. This project uses Gradle for dependency management and building.
- Intellij Platform: A development platform provided by JetBrains that is built on top of IntelliJ IDEA. It offers a set of APIs and tools for extending IntelliJ functionality through plugins.
- Gradle plugins: Plugin dependencies declared in the project's Gradle configuration, used for extending and customizing the gradle build process. The current project relies on various Gradle plugins such as `java`, `org.jetbrains.kotlin.jvm`, `org.jetbrains.intellij`, `org.jetbrains.changelog`, etc.
- the `Target` IntelliJ version: Named in the format of `yyyy.m (e.g., 2023.2)` or `yym.a (e.g., 232.3)`, this refers to the target platform version(s) that the plugin should support. It needs to be declared in the plugin project.

## Project Structure

For details, please see [https://plugins.jetbrains.com/docs/intellij/creating-plugin-project.html#components-of-a-wizard-generated-gradle-intellij-platform-plugin](https://plugins.jetbrains.com/docs/intellij/creating-plugin-project.html#components-of-a-wizard-generated-gradle-intellij-platform-plugin)

```markdown
intellij-kcl
├── gradle
│  └── wrapper
│    ├── gradle-wrapper.jar
│    └── gradle-wrapper.properties    # Declares the dependency on a specific version of Gradle for the project. This enables the development team to use the same version of Gradle. It is used in conjunction with the gradlew/gradlew.bat scripts.
├── src
│  └── main
│    ├── java
│    └── resources
│      └── META-INF
│        ├── plugin.xml               # Plugin metadata containing information such as the plugin name, ID, category, vendor, description, supported extension points, etc.
│        └── pluginIcon.svg
├── build.gradle.kts                  # Configuration file for building and compiling the Gradle project. It declares plugin and library dependencies, as well as tasks for compiling, building, testing, and publishing.
├── gradle.properties                 # Gradle configuration properties referenced by the build.gradle file.
├── gradlew                           # Script used for managing and automatically downloading the specified version of Gradle. It is used in conjunction with the Gradle Wrapper configuration. The gradlew (or gradlew.bat) script is used to execute the build and compilation without the need for locally installing Gradle. It ensures that all project team members use the same version of Gradle, avoiding potential build issues due to version differences.
├── gradlew.bat
└── settings.gradle.kts               # Project metadata, such as the project name.
```

## Build Guide

### Build

Run the following command to build the project(on windows, the command should be `./gradlew.bat build`). If the build is successful, a `BUILD SUCCESSFUL` message will be displayed, and a release package named `intellij-kcl-.zip` will be generated in the `./build/distributions` directory.

```shell
./gradlew build
```

### Test

To run tests, execute the following command or trigger the `Run Tests` task in the Intellij IDEA > Gradle toolbar.

```shell
./gradlew test
```

The test reports will be output to:

- Junit test report: `./build/test-results/test/TEST-xx.xml`
- Html test report: `./build/reports/configuration-cache/xx/xx/configuration-cache-report.html`

### Run Plugin

We might need to run and verify the plugin frequently. To launch a local IDE runtime environment with our intellij-kcl plugin, execute the following command, or trigger the `Run Plugin` task in the Intellij IDEA > Gradle toolbar.

```shell
$ ./gradlew runIde
```

![run sample](./docs/img/how-to-run-1.png)

### Upgrade Plugin

This plugin is built on top of the [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/intellij-platform.html). When updating the Intellij-based IDE product, it is necessary to ensure the compatibility between the plugin and the IDE:

- In the `build.gradle.kts` file, set the `intellij.version` to the version of the IntelliJ Platform SDK used for plugin build, and declare the lower bound and upper bound versions compatible with the IntelliJ product through `tasks.patchPluginXml.sinceBuild` and `tasks.patchPluginXml.untilBuild`.
- Regularly check the compatibility between the version of the IDE and the plugin: when a new version of the intellij-based IDE is released, set `pluginUntilBuild` in the `gradle.properties` file to the version number of the new version (for example, 2023.1 for version number 231), and verify compatibility by running `./gradlew verifyPluginConfiguration` or trigger the `verifyPluginConfiguration` task in the IntelliJ IDEA > gradle toolbar.

### Publish Plugin

To register and publish to the plugin marketplace, see: [https://plugins.jetbrains.com/docs/intellij/plugin-signing.html#provide-secrets-to-ide](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html#provide-secrets-to-ide) [https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html)

## Lexer & Parser Generation

### Parser Generator

- Install the Grammar-Kit plugin
- `src/main/java/io/kusionstack/kcl/kcl.bnf` > right-click and select `Generate Parser Code`. The generated files will be output to `src/main/gen/io/kusionstack/kcl/parser` and `src/main/gen/io/kusionstack/kcl/psi`.
- Configure IntelliJ IDEA to mark the gen directory as a source code root: IntelliJ IDEA file tree > `src/main/gen` > Right-click and select "Mark Directory as" > "Generated Sources Root."

### Lexer Generator

- Install the Grammar-Kit plugin
- Ensure that the project root directory has files `jflex-1.7.0-2.jar` and `idea-flex.skeleton`
- `src/main/java/io/kusionstack/kcl/kcl.flex` > right-click and select `Run Jflex Generator`. The generated files will be output to `src/main/gen/io/kusionstack/kcl/lexer`.
- Configure IntelliJ IDEA to mark the gen directory as a source code root: IntelliJ IDEA file tree > `src/main/gen` > Right-click and select "Mark Directory as" > "Generated Sources Root."

## Frequently Asked Questions

### Platform Version Compatibility

The plugin should be compatible across different IntelliJ Platform versions unless for special reasons. However, there may be some API changes that are not backward compatible between major IntelliJ versions.

For version differences, please refer to:

- [https://plugins.jetbrains.com/docs/intellij/api-changes-list.html](https://plugins.jetbrains.com/docs/intellij/api-changes-list.html)
- [https://plugins.jetbrains.com/docs/intellij/api-notable.html](https://plugins.jetbrains.com/docs/intellij/api-notable.html)

And we can use the predefined Gradle task (`verifyPluginConfiguration`) to verify the compatibility between the plugin and the platform: [https://plugins.jetbrains.com/docs/intellij/verifying-plugin-compatibility.html](https://plugins.jetbrains.com/docs/intellij/verifying-plugin-compatibility.html)

### Gradle Intellij Plugin Version Compatibility

It is recommended to always use the latest version. Here are some notable compatibility requirements:

- For IntelliJ 2022.3+, Gradle IntelliJ Plugin version 1.10.1+ is required.
- Note that starting from IntelliJ 2023.3+, the Gradle plugin is no longer built-in and needs to be installed separately.

### JDK Version Compatibility

For different target intellij platform versions, we'll need different Java Runtime versions:

- 2020.3 and before: Java 11
- 2022.2 and after: Java 17
  
For the compatibility table, please refer to: [https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html#platformVersions](https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html#platformVersions)

#### Which target Platform Versions to maintain

The plugin needs to target different IntelliJ Platform versions. If necessary, separate branches can be created for different IntelliJ major versions (e.g., starting from 2023.2+, supporting LSP, we maintain the LSP-related plugin code in a separate branch).

Which versions to focus on maintaining can be decided based on the distribution of user-side versions provided by Jetbrains: [https://plugins.jetbrains.com/docs/marketplace/product-versions-in-use-statistics.html](https://plugins.jetbrains.com/docs/marketplace/product-versions-in-use-statistics.html)

### Build Failed: Download Timeout

The first time you run ./gradlew build can be quite time-consuming (around 5-15 minutes depending on network conditions) because it needs to download the IntelliJ Platform SDK (about 900M) that the build depends on. If the build fails due to a download timeout, you can run the command again to continue the download.

### Build Failed: Class xxTest Not Found

When a test class is deleted and rebuilt, IntelliJ IDEA still attempts to run the deleted test class. You need to clear the cache.

## References

- Custom Language Plugin Development Guide: [https://plugins.jetbrains.com/docs/intellij/custom-language-support.html](https://plugins.jetbrains.com/docs/intellij/custom-language-support.html)
- Plugin Testing Guide: [https://jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html](https://jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html)
- Plugin Project Configuration: [https://plugins.jetbrains.com/docs/intellij/configuring-plugin-project.html](https://plugins.jetbrains.com/docs/intellij/configuring-plugin-project.html)
- JDK and IntelliJ Platform SDK Compatibility: [https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html](https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html)
- Find all plugin repositories that implement a certain extension point: [https://plugins.jetbrains.com/intellij-platform-explorer/extensions?extensions=com.intellij.lineIndentProvider](https://plugins.jetbrains.com/intellij-platform-explorer/extensions?extensions=com.intellij.lineIndentProvider)

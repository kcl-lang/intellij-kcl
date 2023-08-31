## Environment Requirements

- Install IntelliJ IDEA
- Install JDK11
- Encoding settings: set Default encoding for properties files in IntelliJ IDEA > Preference > File Encoding > Properties files(*.properties) to UTF-8

## Project Structure

For details, please see https://plugins.jetbrains.com/docs/intellij/creating-plugin-project.html#components-of-a-wizard-generated-gradle-intellij-platform-plugin

## Build Guide

### Build

Run the following command to build the project. If the build is successful, a `BUILD SUCCESSFUL` message will be displayed, and a release package named `intellij-kcl-.zip` will be generated in the `./build/distributions` directory.

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

To register and publish to the plugin marketplace, see: https://plugins.jetbrains.com/docs/intellij/plugin-signing.html#provide-secrets-to-ide https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html

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

### Build Failed: Download Timeout

The first time you run ./gradlew build can be quite time-consuming (around 5-15 minutes depending on network conditions) because it needs to download the IntelliJ Platform SDK (about 900M) that the build depends on. If the build fails due to a download timeout, you can run the command again to continue the download.

### Build Failed: Class xxTest Not Found

When a test class is deleted and rebuilt, IntelliJ IDEA still attempts to run the deleted test class. You need to clear the cache.

## References
- Custom Language Plugin Development Guide: https://plugins.jetbrains.com/docs/intellij/custom-language-support.html
- Plugin Testing Guide: https://jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html
- Plugin Project Configuration: https://plugins.jetbrains.com/docs/intellij/configuring-plugin-project.html
- JDK and IntelliJ Platform SDK Compatibility: https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html
- Find all plugin repositories that implement a certain extension point: https://plugins.jetbrains.com/intellij-platform-explorer/extensions?extensions=com.intellij.lineIndentProvider

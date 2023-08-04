## 环境要求

- 安装 intellij IDEA
- 安装 jdk11
- 编码设置：intellij idea > Preference > File Encoding > Properties files(*.properties) > Default encoding for properties files 设置为 UTF-8

## 项目结构

详情参见：https://plugins.jetbrains.com/docs/intellij/creating-plugin-project.html#components-of-a-wizard-generated-gradle-intellij-platform-plugin

## 操作手册

### 构建

运行以下命令执行构建，构建成功将显示`BUILD SUCCESSFUL`，并在`build/distributions`目录下产出名为 intellij-kcl-<version>.zip 的发布包

```shell
./gradlew build
```

### 测试

运行以下命令、或在 Intellij IDEA > Gradle 工具栏窗口选择`Run Tests`。

```shell
./gradlew test
```

测试报告将输出到：
- Junit 测试报告：`./build/test-results/test/TEST-xx.xml`
- Html 测试报告：`build/reports/configuration-cache/xx/xx/configuration-cache-report.html`


### 运行插件

插件开发过程中，我们需要频繁地运行和验证。运行以下命令、或在 Intellij IDEA > Gradle 工具栏窗口选择`Run Plugin`，将在本地启动一个带有 intellij-kcl 插件的 IDE 运行环境：

```shell
./gradlew runIDE
```

![run sample](./docs/img/how-to-run-1.png)

### 插件升级

本插件构建在 [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/intellij-platform.html) 之上，在支持更新版本 Intellij-based IDE 产品时，需要确保插件与产品的兼容性：

- `build.gradle.kts`文件中，设置 `intellij.version` 为插件构建所使用的 IntelliJ Platform SDK 版本；并通过 `tasks.patchPluginXml.sinceBuild` 和 `tasks.patchPluginXml.untilBuild` 声明插件所兼容的 IntelliJ 产品的版本上下限。

- 需要定期检查 IDE 的版本和插件的兼容性：intellij-based IDE 发布新版本时，将 `gradle.properties` 文件中的 `pluginUntilBuild` 设置为新版本的版本号（例如 2023.1，则对应版本号为231），并校验兼容性：运行 `./gradlew verifyPluginConfiguration` 或在 IntelliJ IDEA > gradle 窗口运行 `verifyPluginConfiguration` 任务。

### 插件发布

关于注册和发布到插件市场，参见：https://plugins.jetbrains.com/docs/intellij/plugin-signing.html#provide-secrets-to-ide https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html

## 生成词法 & 语法解析器

#### 语法解析器生成器
- 安装插件 grammar kit
- src/main/java/io/kusionstack/kcl/kcl.bnf 文件内，右键菜单栏选择 `Generate Parser Code`，生成的文件将输出到 `src/main/gen/io/kusionstack/kcl/parser` 和 `src/main/gen/io/kusionstack/kcl/psi`
- 设置 IntelliJ IDEA，将 gen 包标记为源代码根目录：IntelliJ IDEA 文件树 > src/main/gen 目录 > 右键选择 "Mark Directory as" > "Generated Sources Root"

#### 词法解析器生成器
- 安装插件：grammar kit
- 确保项目根目录存在文件：jflex-1.7.0-2.jar 和 idea-flex.skeleton
- src/main/java/io/kusionstack/kcl/kcl.flex 文件内，右键菜单栏选择 `Run Jflex Generator`，生成的文件将输出到 `src/main/gen/io/kusionstack/kcl/lexer`
- 设置 IntelliJ IDEA，将 gen 包标记为源代码根目录：IntelliJ IDEA 文件树 > src/main/gen 目录 > 右键选择 "Mark Directory as" > "Generated Sources Root"

## 常见问题

### 构建失败：下载超时

首次执行 `./gradlew build` 会相当耗时（视网络情况约 5-15分钟），这是因为需要下载构建中所依赖的 IntelliJ Platform SDK（约 900M），如果出现下载超时导致构建退出，可重新执行命令继续下载。

### 构建失败：找不到测试类

- 删除某个测试类后，重新构建时 IntelliJ IDEA 仍然在尝试运行已删除的测试类。需要清理缓存

## 参考资料

- 自定义语言插件研发指南：https://plugins.jetbrains.com/docs/intellij/custom-language-support.html
- 插件测试指南：https://jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html
- 插件项目配置：https://plugins.jetbrains.com/docs/intellij/configuring-plugin-project.html
- jdk 和 IntelliJ Platform SDK 兼容性： https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html
- 查找依赖某个扩展点的所有插件仓库：https://plugins.jetbrains.com/intellij-platform-explorer/extensions?extensions=com.intellij.lineIndentProvider

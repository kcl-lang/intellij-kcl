## 环境要求

- 安装 intellij IDEA
- JDK 11 和 JDK 17
- 安装插件 Gradle Intellij Plugin 最新版本
- 编码设置：intellij idea > Preference > File Encoding > Properties files(*.properties) > Default encoding for properties files 设置为 UTF-8

## 术语和概念

- intellij-kcl 插件：本项目
- Gradle Intellij Plugin：gradle IDE 插件，提供对 gradle 项目的编译、构建集成；本项目是使用 gradle 管理依赖和构建的。
- intellij platform：JetBrains 提供的构建在 IntelliJ IDEA 基础上的开发平台，提供了一组 API 和工具以供插件扩展 intellij 功能。
- gradle plugins：在项目的 gradle 配置声明插件依赖，用于扩展和定制构建过程。当前项目依赖的 gradle 插件有：`java`、`org.jetbrains.kotlin.jvm`、`org.jetbrains.intellij`、`org.jetbrains.changelog` 等。
- target intellij 版本号：采用 `yyyy.m 如2023.2` 或 `yym.a 如232.3` 格式命名，在插件项目中需要声明插件所 target 的目标平台版本号（范围）。

## 项目结构

详情参见：[https://plugins.jetbrains.com/docs/intellij/creating-plugin-project.html#components-of-a-wizard-generated-gradle-intellij-platform-plugin](https://plugins.jetbrains.com/docs/intellij/creating-plugin-project.html#components-of-a-wizard-generated-gradle-intellij-platform-plugin)

```markdown
intellij-kcl
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties # 声明项目对 gradle 版本的依赖，便于项目的研发成员使用相同版本的 gradle，配合下面的 gradlew/gradlew.bat 脚本使用
├── src
│   └── main
│       ├── java
│       └── resources
│           └── META-INF
│               ├── plugin.xml      # 插件的 metadata，如插件名称、id、插件类别、vendor、description、扩展点支持等
│               └── pluginIcon.svg
├── build.gradle.kts                # 构建和编译gradle项目所需的配置，声明gradle插件和库依赖、声明和编排编译、构建、测试、发布等的task
├── gradle.properties               # 被 build.gradle 文件引用的 gradle 配置变量
├── gradlew                         # 是用于管理和自动下载 gradle 版本的脚本，配合 gradle wrapper 配置使用，可以用 gradlew（或 gradlew.bat）脚本来执行构建和编译，无需在本地安装 gradle，好处是确保项目的研发成员使用相同版本的 gradle，避免版本差异导致的构建问题
├── gradlew.bat
└── settings.gradle.kts             # 项目的 metadata，如项目名
```

## 操作手册

### 构建

运行以下命令执行构建，构建成功将显示 `BUILD SUCCESSFUL`，并在 `./build/distributions` 目录下产出名为 `intellij-kcl-<version>.zip` 的发布包

```shell
./gradlew build
```

### 测试

运行以下命令、或在 Intellij IDEA > Gradle 工具栏窗口选择 `Run Tests`。

```shell
./gradlew test
```

测试报告将输出到：

- Junit 测试报告：`./build/test-results/test/TEST-xx.xml`
- Html 测试报告：`./build/reports/configuration-cache/xx/xx/configuration-cache-report.html`

### 运行插件

插件开发过程中，我们需要频繁地运行和验证。运行以下命令、或在 Intellij IDEA > Gradle 工具栏窗口选择 `Run Plugin`，将在本地启动一个带有 intellij-kcl 插件的 IDE 运行环境：

```shell
./gradlew runIDE
```

![run sample](./docs/img/how-to-run-1.png)

### 插件升级

本插件构建在 [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/intellij-platform.html) 之上，在支持更新版本 Intellij-based IDE 产品时，需要确保插件与产品的兼容性：

- `build.gradle.kts` 文件中，设置 `intellij.version` 为插件构建所使用的 IntelliJ Platform SDK 版本；并通过 `tasks.patchPluginXml.sinceBuild` 和 `tasks.patchPluginXml.untilBuild` 声明插件所兼容的 IntelliJ 产品的版本上下限。
- 需要定期检查 IDE 的版本和插件的兼容性：intellij-based IDE 发布新版本时，将 `gradle.properties` 文件中的 `pluginUntilBuild` 设置为新版本的版本号（例如 2023.1，则对应版本号为 231），并校验兼容性：运行 `./gradlew verifyPluginConfiguration` 或在 IntelliJ IDEA > gradle 窗口运行 `verifyPluginConfiguration` 任务。

### 插件发布

关于注册和发布到插件市场，参见：[https://plugins.jetbrains.com/docs/intellij/plugin-signing.html#provide-secrets-to-ide](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html#provide-secrets-to-ide) [https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html)

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

### platform 版本兼容性

如没有特殊原因，应当保持插件在不同 intellij platform 的兼容性。但 intellij 主版本之间往往有一些不兼容的 API 变动，版本间差异参见：
[https://plugins.jetbrains.com/docs/intellij/api-changes-list.html](https://plugins.jetbrains.com/docs/intellij/api-changes-list.html)
[https://plugins.jetbrains.com/docs/intellij/api-notable.html](https://plugins.jetbrains.com/docs/intellij/api-notable.html)
使用预先定义的 gradle task (verifyPluginConfiguration)可验证插件和平台的兼容性：[https://plugins.jetbrains.com/docs/intellij/verifying-plugin-compatibility.html](https://plugins.jetbrains.com/docs/intellij/verifying-plugin-compatibility.html)

### gradle intellij plugin 版本兼容性

推荐始终使用 latest 版本。2022.3+ 版本需要 Gradle IntelliJ Plugin version 1.10.1+
需要注意 gradle 插件自 intellij 2023.3+ 开始不再内置在 ide 内，需要自行安装。

### JDK 版本兼容性

由于项目构建所依赖的 platform 版本对于 Java Runtime 的

- 2020.3 及以前：Java 11
- 2022.2 及以后：Java 17

兼容性表格参见：[https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html#platformVersions](https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html#platformVersions)

### 同时维护哪些 platform 版本

插件需要 target 不同的 Intellij platform 版本，因此，必要的话可以为不同 intellij 主版本创建对应的插件代码分支（例如 2023.2+ 开始支持 lsp，我们把 lsp 相关的插件代码维护在了单独的分支）
重点维护的版本可跟踪 intellij 提供的用户侧版本分布而定：[https://plugins.jetbrains.com/docs/marketplace/product-versions-in-use-statistics.html](https://plugins.jetbrains.com/docs/marketplace/product-versions-in-use-statistics.html)

### 构建失败：下载超时

首次执行 `./gradlew build` 会相当耗时（视网络情况约 5-15 分钟），这是因为需要下载构建中所依赖的 IntelliJ Platform SDK（约 900M），如果出现下载超时导致构建退出，可重新执行命令继续下载。

### 构建失败：找不到测试类

- 删除某个测试类后，重新构建时 IntelliJ IDEA 仍然在尝试运行已删除的测试类。需要清理缓存

## 参考资料

- 自定义语言插件研发指南：[https://plugins.jetbrains.com/docs/intellij/custom-language-support.html](https://plugins.jetbrains.com/docs/intellij/custom-language-support.html)
- 插件测试指南：[https://jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html](https://jetbrains.org/intellij/sdk/docs/tutorials/writing_tests_for_plugins.html)
- 插件项目配置：[https://plugins.jetbrains.com/docs/intellij/configuring-plugin-project.html](https://plugins.jetbrains.com/docs/intellij/configuring-plugin-project.html)
- jdk 和 IntelliJ Platform SDK 兼容性： [https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html](https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html)
- 查找依赖某个扩展点的所有插件仓库：[https://plugins.jetbrains.com/intellij-platform-explorer/extensions?extensions=com.intellij.lineIndentProvider](https://plugins.jetbrains.com/intellij-platform-explorer/extensions?extensions=com.intellij.lineIndentProvider)

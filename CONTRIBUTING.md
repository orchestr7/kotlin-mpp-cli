# Guides and tricks on the development

Small guide that contain information and HOW-TOs

## Building
The project is built using gradle. To produce an executable, execute the following
(the task is an alias, which is resolved depending on the current platform):
```bash
$ ./gradlew :kotlin-mpp-cli:linkReleaseExecutableMultiplatform
```
The compiled binary resides in the following location: `kotlin-mpp-cli/build/bin/<target>/<mode>Executable/kotlin-mpp-cli-<version>.[k]exe`

To speed up local development we advise to add the following properties into [gradle.properties](gradle.properties):
```properties
reckon.stage=snapshot
detekt.multiplatform.disabled=true
disableRedundantTargets=true
```
Setting project version to snapshot allows gradle to cache stuff more effectively. Disabling detekt (see [Code style] section below)
reduces build time, and checks can be executed separately on during CI. Finally, `disableRedundantTargets` disables cross-compilations
and leaves only default target for current platform.

To build all subprojects and run tests, you can simply execute
```bash
$ ./gradlew build
```

### Important
There could be some problems in the resolving of dependencies in IDEA due to a weak Kotlin gradle multiplatform support. 

### kotlin-mpp-cli and adding new cli options
To add a new cli option to save simply add this option to `buildSrc/src/main/resources/config-options.json`. Once the project
is built, it will be added to [OptionsTable.md](OptionsTable.md) and to the generated `Properties.kt` file.

### Code style
Code style and code smells are checked using [diktat](https://github.com/saveourtool/diktat) and [detekt](https://github.com/detekt/detekt).

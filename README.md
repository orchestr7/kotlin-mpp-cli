## <img src="/ktoml.png" width="300px"/>

![Releases](https://img.shields.io/github/v/release/akuleshov7/ktoml)
![Maven Central](https://img.shields.io/maven-central/v/com.akuleshov7/ktoml-core)
![License](https://img.shields.io/github/license/akuleshov7/ktoml)
![Build and test](https://github.com/akuleshov7/ktoml/actions/workflows/build_and_test.yml/badge.svg?branch=main)
![Lines of code](https://img.shields.io/tokei/lines/github/akuleshov7/ktoml)
![Hits-of-Code](https://hitsofcode.com/github/akuleshov7/ktoml?branch=main)
![GitHub repo size](https://img.shields.io/github/repo-size/akuleshov7/ktoml)
![Run deteKT](https://github.com/akuleshov7/ktoml/actions/workflows/detekt.yml/badge.svg?branch=main)
![Run diKTat](https://github.com/akuleshov7/ktoml/actions/workflows/diktat.yml/badge.svg?branch=main)

My cli application description

## Acknowledgement
Special thanks to those awesome developers who give us great suggestions, help us to maintain and improve this project:
@akuleshov7

## Supported platforms
Main part of the code is written in Kotlin **common** module. This means that it can be built for each and every Kotlin native platform.
However, to reduce the scope, ktoml now supports only the following platforms:
- jvm
- mingwx64
- linuxx64
- macosx64

:globe_with_meridians: latest supported Kotlin version: 1.8

## Dependency
<details>
<summary>Maven</summary>

```pom
<dependency>
</dependency>
```
</details>

<details>
<summary>Gradle Groovy</summary>

```groovy
implementation 

```
</details>

## How to use
`--help`
[OptionsTable.md](OptionsTable.md)

## Small notes about architecture of this project:
Main modules:
- cli: contains main method and cli-related things
- common: common logic like data models and so on
- core: core business logic and a framework (if any)

## Fix me:
- need to support generation of package name
- need to support usage of application name in releasing (release.yml)
- badges generation (based on the cli and package name)
- replace 'com.akuleshov7.cli' to your package domain name
- replace everywhere 'kotlin-mpp-cli' to your name of the project
- do not forget to change Publishing configuration (license, url, etc.)

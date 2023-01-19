![License](https://img.shields.io/github/license/akuleshov7/kotlin-mpp-cli)
![Build and test](https://github.com/akuleshov7/kotlin-mpp-cli/actions/workflows/build_and_test.yml/badge.svg?branch=main)
![Hits-of-Code](https://hitsofcode.com/github/akuleshov7/kotlin-mpp-cli?branch=main)
![GitHub repo size](https://img.shields.io/github/repo-size/akuleshov7/kotlin-mpp-cli)
![Run deteKT](https://github.com/akuleshov7/kotlin-mpp-cli/actions/workflows/detekt.yml/badge.svg?branch=main)
![Run diKTat](https://github.com/akuleshov7/kotlin-mpp-cli/actions/workflows/diktat.yml/badge.svg?branch=main)

Want to write a native cli application, but do not want to write it in C/C++? 
Do not want users to think about installing SDK (like Python, JDK/JRE, etc.) and related dependencies?
You can easily and quickly write your application using Kotlin MPP and have Native executables using this template!
All boilerplate is already done in this template, so no need to spend days on the boring work and on the setup of 
environment, all you need - to implement business logic.

We did this boring work for you, so don't forget to give a star to this project to save it in your list! :star:

## What's inside
:white_check_mark: Github actions build/release scripts to Central and Github Releases \
:white_check_mark: Gradle build/release tasks for Kotlin MPP \
:white_check_mark: Code analysis enabled with a full GitHub integration \
:white_check_mark: Junit testing report integration with Github \
:white_check_mark: Nice and easy code generation for cli from a config file \
:white_check_mark: Application that is based on `kotlinx.cli` \
:white_check_mark: Utility methods for a cli application 

## How to use it
0. Create a new repository based on this template using Github: `Use this template` -> `Create a new repository`;
1. Replace everywhere 'kotlin-mpp-cli' to your name of the project;
2. Replace 'com.akuleshov7.cli' to your package domain name in code and directory names (!); 
3. Run `CliPropertiesTest.kt` on JVM to check that everything is setup correctly;
4. Add your cli options to `buildSrc/src/main/resources/config-options.json` (and `config-arguments.json`);
5. Once the project is built (`./gradlew build`), [OptionsTable.md](OptionsTable.md), `CliProperties.kt` files will be generated;
6. Implement the business logic of your application in `core` module (`BusinessLogic` class);
7. Do not forget to change Publishing configuration (license, git url, etc.) in `PublishingConfiguration.kt`;
8. Add publishing credentials for Maven central to GitHub: `OSSRH_USERNAME`, `OSSRH_PASSWORD`, `GPG_SEC`, `GPG_PASSWORD`.
Read more [here](https://central.sonatype.org/publish/publish-gradle/).

## Useful scripts
1. To build project: `./gradlew build`
2. To run diktat auto-fix: `./gradlew diktatFix`
3. To run detekt: `./gradlew detektAll`

## Supported platforms
Main part of the code is written in Kotlin **common** module. This means that it can be built for each and every Kotlin native platform.
However, to reduce the scope, kotlin-mpp-cli now supports only the following platforms:
- jvm
- mingwx64
- linuxx64
- macosx64
- macosArm64 (M1+)

:globe_with_meridians: latest supported Kotlin version: 1.8

## Small notes about an architecture of this project
Main modules:
- cli: contains `main` method and cli-related things
- common: common logic like data models and so on
- core: core business logic and a framework (if any)

## Intellij IDEA problems
JB still has a limited support to MPP projects, so you probably will have problems while indexing of this project in IDE.
Known problems:
- `CliProperties` probably can be ignored by indexing and marked as unknown dependency;
- `main` method is not runnable out of the box in IDE, but you can run it using [run-configuration](.run/MainKtJvm.run.xml).

## Acknowledgement
Special thanks to those developers who help us to make this project:
@akuleshov7 @petertrr

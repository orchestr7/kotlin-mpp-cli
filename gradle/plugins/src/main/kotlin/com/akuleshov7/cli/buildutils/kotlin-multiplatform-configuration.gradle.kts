/**
 * Precompiled script plugin, that applies common configuration for a KMP project.
 * It specifies common targets and sets some common compiler flags.
 * It creates a number of useful source sets and adds common dependencies.
 * These source sets can be retrieved in a particular build script and configured further as needed.
 */

package com.akuleshov7.cli.buildutils

import org.gradle.kotlin.dsl.*
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentOperatingSystem

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
                freeCompilerArgs = freeCompilerArgs + "-Xjvm-default=all"
            }
        }
    }
    val nativeTargets = listOf(linuxX64(), mingwX64(), macosX64(), macosArm64())

    if (hasProperty("disableRedundantTargets") && (property("disableRedundantTargets") as String?) != "false") {
        // with this flag we exclude targets that are present on multiple OS to speed up build
        val currentOs = DefaultNativePlatform.getCurrentOperatingSystem()
        val redundantTarget: String? = when {
            currentOs.isWindows -> "linuxX64"
            currentOs.isMacOsX -> "linuxX64"
            currentOs.isLinux -> null
            else -> throw GradleException("Unknown operating system ${currentOs.name}")
        }
        tasks.matching { redundantTarget != null && it.name.contains(redundantTarget, ignoreCase = true) }
            .configureEach {
                logger.lifecycle("Disabling task :${project.name}:$name on host $currentOs")
                enabled = false
            }
    }

    /* Common structure for MPP libraries:
    *            common
    *              |
    *            nonJs
    *          /       \
    *       native      JVM
    *     /   |    \
    * linux  mingw macos
    */

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation("io.kotest:kotest-assertions-core:5.5.4")
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(kotlin("test-junit5"))
                implementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
            }
        }
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }
        nativeTargets.forEach {
            getByName("${it.name}Main").dependsOn(nativeMain)
        }
        nativeTargets.forEach {
            getByName("${it.name}Test").dependsOn(nativeTest)
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

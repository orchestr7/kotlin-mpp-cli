import com.akuleshov7.cli.generation.argumentsConfigFilePath
import com.akuleshov7.cli.generation.generateConfigOptions
import com.akuleshov7.cli.generation.optionsConfigFilePath

plugins {
    id("com.akuleshov7.cli.buildutils.kotlin-multiplatform-configuration")
    id("com.akuleshov7.cli.buildutils.code-quality-convention")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.okio)
                implementation(libs.kotlinx.cli)
                implementation(libs.kotlinx.serialization.properties)
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.datetime)
                implementation(files("/generated/src"))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(files("/generated/src"))
            }
        }
    }
}

val generateConfigOptionsTaskProvider = tasks.register("generateConfigOptions") {
    inputs.file(optionsConfigFilePath())
    inputs.file(argumentsConfigFilePath())
    val generatedFile = File("$buildDir/generated/src/com/akuleshov7/cli/common/config/CliProperties.kt")
    outputs.file(generatedFile)

    doFirst {
        generateConfigOptions(generatedFile)
    }
}

// saving CLI version to a file
val generateVersionFileTaskProvider = tasks.register("generateVersionsFile") {
    inputs.property("project version", version.toString())
    val versionsFile = File("$buildDir/generated/src/com/akuleshov7/cli/common/config/Version.kt")
    outputs.file(versionsFile)

    doFirst {
        versionsFile.parentFile.mkdirs()
        versionsFile.writeText(
            """
            package com.akuleshov7.cli.common.config

            public const val VERSION = "$version"

            """.trimMargin()
        )
    }
}

setOf("nativeMain", "jvmMain", "commonMain").forEach { name ->
    kotlin.sourceSets.getByName(name) {
        kotlin.srcDir("$buildDir/generated/src")
    }
}

// specific task for the generation of Properties.kt and Version.kt file
tasks.configureEach {
    if (!setOf(generateConfigOptionsTaskProvider.name, generateVersionFileTaskProvider.name).contains(this.name)) {
        this.dependsOn(generateConfigOptionsTaskProvider)
        this.dependsOn(generateVersionFileTaskProvider)
    }
}

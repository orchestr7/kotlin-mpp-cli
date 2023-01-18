

plugins {
    id("com.akuleshov7.cli.buildutils.kotlin-multiplatform-configuration")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.common)
                api(libs.okio)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(libs.kotlinx.coroutines.core)
            }
        }
    }
}

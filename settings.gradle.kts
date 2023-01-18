rootProject.name = "kotlin-mpp-cli"

includeBuild("gradle/plugins")
include("common")
include("driver")
include("core")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

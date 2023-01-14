rootProject.name = "kotlin-mpp-cli"

include("common")
include ("cli")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

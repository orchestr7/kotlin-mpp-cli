plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    // workaround https://github.com/gradle/gradle/issues/15383
    implementation(files(project.libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradle.plugin) {
        because("Add plugin on plugin classpath here to automatically set its version for the whole build")
    }
    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("com.google.code.gson:gson:2.10")
}

plugins {
    id("com.akuleshov7.cli.buildutils.versioning-configuration")
    id("com.akuleshov7.cli.buildutils.code-quality-convention")
    id("com.akuleshov7.cli.buildutils.publishing-configuration")
    java
}

allprojects {
    configurations.all {
        // if SNAPSHOT dependencies are used, refresh them periodically
        resolutionStrategy.cacheDynamicVersionsFor(10, TimeUnit.MINUTES)
        resolutionStrategy.cacheChangingModulesFor(10, TimeUnit.MINUTES)
    }
}

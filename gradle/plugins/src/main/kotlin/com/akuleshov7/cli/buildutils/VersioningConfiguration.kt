/**
 * Configuration for project versioning
 */

package com.akuleshov7.cli.buildutils

import org.ajoberstar.grgit.gradle.GrgitServiceExtension
import org.ajoberstar.grgit.gradle.GrgitServicePlugin
import org.ajoberstar.reckon.gradle.ReckonExtension
import org.ajoberstar.reckon.gradle.ReckonPlugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

/**
 * Configures reckon plugin for [this] project, should be applied for root project only
 */
fun Project.configureVersioning() {
    apply<ReckonPlugin>()
    apply<GrgitServicePlugin>()
    val grgitProvider = project.extensions.getByType<GrgitServiceExtension>()
        .service
        .map { it.grgit }

    configure<ReckonExtension> {
        scopeFromProp()
        stageFromProp("alpha", "rc", "final")
    }

    val grgit = grgitProvider.get()
    val status = grgit.repository.jgit.status()
        .call()
    if (!status.isClean) {
        logger.warn("git tree is not clean; " +
                "Untracked files: ${status.untracked}, uncommitted changes: ${status.uncommittedChanges}"
        )
    }
}

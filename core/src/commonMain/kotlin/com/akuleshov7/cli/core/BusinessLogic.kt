package com.akuleshov7.cli.core

import com.akuleshov7.cli.common.config.CliProperties
import com.akuleshov7.cli.common.logging.logDebug

/**
 * @property cliProperties parsed properties with code generation
 */
open class BusinessLogic(val cliProperties: CliProperties) {
    /**
     * execution of your main business logic
     */
    fun execute() {
        logDebug("Running main logic")
    }
}

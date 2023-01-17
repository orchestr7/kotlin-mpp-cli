/**
 * Utility and validation methods for
 */

package com.akuleshov7.cli.driver.config

import com.akuleshov7.cli.common.config.CliProperties
import com.akuleshov7.cli.common.logging.logDebug
import com.akuleshov7.cli.common.logging.logType
import com.akuleshov7.cli.driver.fs

/**
 * @param args CLI args
 * @return an instance of [CliProperties]
 */
fun CliProperties.Companion.of(args: Array<String>): CliProperties {
    val configFromCli = parseArgs(fs, args)

    tryToUpdateDebugLevel(configFromCli)
    logDebug("Using the following properties:\n$configFromCli")
    return configFromCli.validate()
}

/**
 * You can do validations for your properties here
 *
 * @return this config in case we have valid configuration
 */
private fun CliProperties.validate(): CliProperties {
    logDebug("Validating CLI properties")
    return this
}

private fun tryToUpdateDebugLevel(properties: CliProperties) {
    logType.set(properties.logType)
}

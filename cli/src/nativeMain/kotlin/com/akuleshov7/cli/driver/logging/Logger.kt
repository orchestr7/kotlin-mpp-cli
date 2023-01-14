/**
 * Logging utilities specific for native code.
 */

package com.akuleshov7.cli.driver.logging

import com.akuleshov7.cli.driver.ExitCodes
import kotlin.system.exitProcess

actual fun logErrorAndExit(exitCode: ExitCodes, message: String): Nothing {
    logError(message)
    exitProcess(exitCode.code)
}

actual fun logWarn(messageSupplier: () -> String) {
    logWarn(messageSupplier())
}

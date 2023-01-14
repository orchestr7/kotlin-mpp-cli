/**
 * Logging utilities specific for native code.
 */

package com.akuleshov7.cli.driver.logging

import com.akuleshov7.cli.driver.ExitCodes

/**
 * Log [message] with level ERROR and exit process with code [exitCode]
 *
 * @param exitCode exit code
 * @param message message to log
 * @return nothing, program terminates in this method
 */
@Deprecated("never use this method in your cloud or spring applications (becuase you can exit the process)")
expect fun logErrorAndExit(exitCode: ExitCodes, message: String): Nothing

/**
 * Log result of [messageSupplier] with level WARN
 *
 * @param messageSupplier supplier for message to log
 */
expect fun logWarn(messageSupplier: () -> String): Unit

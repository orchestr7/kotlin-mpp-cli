package com.akuleshov7.cli.common

import com.akuleshov7.cli.common.config.CliProperties
import com.akuleshov7.cli.common.config.LogType
import com.akuleshov7.cli.driver.config.of
import kotlin.test.Test
import kotlin.test.assertEquals

class CliPropertiesTest {
    @Test
    fun testCreationOfCliPropertiesFromArgs() {
        val args = arrayOf(".", "--log", "all")
        val config = CliProperties.of(args)

        assertEquals(config.logType, LogType.ALL)
    }
}

package com.akuleshov7.cli.buildutils

plugins {
    id("com.akuleshov7.cli.buildutils.detekt-convention-configuration")
    id("com.akuleshov7.cli.buildutils.diktat-convention-configuration")
}

// FixMe: only registers the task, doesn't actually install them
installGitHooks()

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

/*
*  /Users/rezafaraji/Desktop/portfolio/keys/ktor-server -r /Users/rezafaraji/Desktop/myportfolio/* root@95.216.167.123:/var/www/rezafaraji.dev
*/


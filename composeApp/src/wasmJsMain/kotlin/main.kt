@file:OptIn(ExperimentalBrowserHistoryApi::class)

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    val body = document.body ?: return

    ComposeViewport(body) {
        App(
            onNavHostReady = { navController ->
                navController.bindToBrowserNavigation()
            }
        )
    }
}
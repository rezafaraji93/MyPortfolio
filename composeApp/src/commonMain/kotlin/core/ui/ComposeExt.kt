package core.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import util.windowSize

@Composable
fun Modifier.autoHorizontalPadding() = composed {
    val animatedHorizontalPadding by animateDpAsState(
        when (windowSize()) {
            WindowWidthSizeClass.Compact -> 20.dp
            WindowWidthSizeClass.Medium -> 48.dp
            else -> 200.dp
        }
    )
    Modifier.padding(horizontal = animatedHorizontalPadding)
}
@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import util.windowSize

@Composable
fun DescriptionComponent(
    modifier: Modifier = Modifier,
    description: String
) {

    val animatedHorizontalPadding by animateDpAsState(
        when (windowSize()) {
            WindowWidthSizeClass.Compact -> 20.dp
            WindowWidthSizeClass.Medium -> 48.dp
            else -> 200.dp
        }
    )

    Text(
        text = description,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = animatedHorizontalPadding)
    )
}
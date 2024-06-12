package theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

@Composable
internal fun AppTheme(
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = colorScheme,
        typography = NetflixTypography(),
        content = {
            Surface(content = content)
        }
    )

}
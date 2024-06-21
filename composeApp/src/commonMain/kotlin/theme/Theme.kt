package theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
    primary = LightEmeraldGreen,
    onPrimary = White,
    primaryContainer = DarkerLightEmeraldGreen,
    onPrimaryContainer = White,
    inversePrimary = LightEmeraldGreen,
    secondary = MintGreen,
    onSecondary = White,
    secondaryContainer = DarkMintGreen,
    onSecondaryContainer = White,
    tertiary = Teal,
    onTertiary = White,
    tertiaryContainer = DarkTeal,
    onTertiaryContainer = White,
    background = JetBlack,
    onBackground = White,
    surface = DarkCharcoal,
    onSurface = White,
    surfaceVariant = DarkSlate,
    onSurfaceVariant = White,
    surfaceTint = LightEmeraldGreen,
    inverseSurface = DimGray,
    inverseOnSurface = JetBlack,
    error = DarkRed,
    onError = White,
    errorContainer = DarkRed,
    onErrorContainer = White,
    outline = DarkGray,
    outlineVariant = DarkGray,
    scrim = Black,
    surfaceBright = DarkCharcoal,
    surfaceContainer = DarkCharcoal,
    surfaceContainerHigh = DarkCharcoal,
    surfaceContainerHighest = DarkCharcoal,
    surfaceContainerLow = DarkCharcoal,
    surfaceContainerLowest = JetBlack,
    surfaceDim = DarkCharcoal
)

@Composable
internal fun AppTheme(
    colorScheme: ColorScheme = DarkColorScheme,
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
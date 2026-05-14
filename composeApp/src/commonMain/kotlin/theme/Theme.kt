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
    secondaryContainer = DeepSlate,
    onSecondaryContainer = White,
    tertiary = Teal,
    onTertiary = White,
    tertiaryContainer = DarkTeal,
    onTertiaryContainer = White,
    background = RichBlack,
    onBackground = White,
    surface = DarkCharcoal,
    onSurface = White,
    surfaceVariant = DarkSlate,
    onSurfaceVariant = White,
    surfaceTint = LightEmeraldGreen,
    inverseSurface = DimGray,
    inverseOnSurface = RichBlack,
    error = DarkRed,
    onError = White,
    errorContainer = DarkRed,
    onErrorContainer = White,
    outline = DimGray,
    outlineVariant = DimGray,
    scrim = Black,
    surfaceBright = DarkCharcoal,
    surfaceContainer = DarkCharcoal,
    surfaceContainerHigh = DeepSlate,
    surfaceContainerHighest = DarkSlate,
    surfaceContainerLow = DarkCharcoal,
    surfaceContainerLowest = RichBlack,
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
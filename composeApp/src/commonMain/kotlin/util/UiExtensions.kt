@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package util

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@Composable
fun windowSize(): WindowWidthSizeClass {
    val windowSizeClass = calculateWindowSizeClass()
    return windowSizeClass.widthSizeClass
}
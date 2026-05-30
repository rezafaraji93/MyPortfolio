package util

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

fun Modifier.appearanceAnimation(
    delayMillis: Int = 0,
    durationMillis: Int = 500
): Modifier = composed {
    val alpha = remember { Animatable(0f) }
    val translateY = remember { Animatable(20f) }

    LaunchedEffect(Unit) {
        if (delayMillis > 0) {
            delay(delayMillis.toLong().milliseconds)
        }
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis)
        )
    }

    LaunchedEffect(Unit) {
        if (delayMillis > 0) {
            delay(delayMillis.toLong().milliseconds)
        }
        translateY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis)
        )
    }

    this.graphicsLayer {
        this.alpha = alpha.value
        this.translationY = translateY.value
    }
}

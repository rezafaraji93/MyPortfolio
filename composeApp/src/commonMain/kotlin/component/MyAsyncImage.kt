package component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.SubcomposeAsyncImage
import util.shimmerEffect

@Composable
fun MyAsyncImage(
    modifier: Modifier = Modifier,
    model: Any?,
    contentScale: ContentScale = ContentScale.Fit
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = model,
        contentDescription = null,
        contentScale = contentScale,
        loading = {
            Box(
                modifier = Modifier
                    .shimmerEffect()
            )
        }
    )
}
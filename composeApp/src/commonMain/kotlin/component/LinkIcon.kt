package component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import model.LinkType
import openUrl
import org.jetbrains.compose.resources.painterResource

@Composable
fun LinkIcon(
    modifier: Modifier = Modifier, 
    linkType: LinkType
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val scale by animateFloatAsState(if (isHovered) 1.2f else 1f)
    val colorFilter by animateColorAsState(
        if (isHovered) MaterialTheme.colorScheme.primary 
        else MaterialTheme.colorScheme.onSurfaceVariant
    )

    Image(
        painter = painterResource(linkType.icon),
        contentDescription = null,
        colorFilter = ColorFilter.tint(colorFilter),
        modifier = modifier
            .size(40.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clip(CircleShape)
            .hoverable(interactionSource)
            .clickable {
                openUrl(linkType.linkUrl)
            }
    )
}

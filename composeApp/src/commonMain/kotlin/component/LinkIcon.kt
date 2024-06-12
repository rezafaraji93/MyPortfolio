package component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.LinkType
import openUrl
import org.jetbrains.compose.resources.painterResource

@Composable
fun LinkIcon(
    modifier: Modifier = Modifier, linkType: LinkType
) {

    Image(painter = painterResource(linkType.icon),
        contentDescription = null,
        modifier = modifier.size(45.dp).clickable {
                openUrl(linkType.linkUrl)
            })

}
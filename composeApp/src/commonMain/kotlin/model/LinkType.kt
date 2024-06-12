package model

import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.github
import myportfolio.composeapp.generated.resources.linkedin
import org.jetbrains.compose.resources.DrawableResource
import util.GITHUB_URL
import util.LINKEDIN_URL

sealed class LinkType(
    val icon: DrawableResource,
    val linkUrl: String
) {
    data object LinkedIn: LinkType(
        icon = Res.drawable.linkedin,
        linkUrl = LINKEDIN_URL
    )
    data object Github: LinkType(
        icon = Res.drawable.github,
        linkUrl = GITHUB_URL
    )
}
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
    data class LinkedIn(val url: String?): LinkType(
        icon = Res.drawable.linkedin,
        linkUrl = url ?: LINKEDIN_URL
    )
    data class Github(val url: String?): LinkType(
        icon = Res.drawable.github,
        linkUrl = url ?: GITHUB_URL
    )
}
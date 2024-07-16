package core.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectDto(
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("link")
    val link: String,
    @SerialName("title")
    val title: String
)
package core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    @SerialName("about_me")
    val aboutMe: String,
    @SerialName("cv_url")
    val cvUrl: String,
    @SerialName("experiences")
    val experienceDtos: List<ExperienceDto>,
    @SerialName("github_url")
    val githubUrl: String,
    @SerialName("linkedin_url")
    val linkedinUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("profile_picture")
    val profilePicture: String,
    @SerialName("projects")
    val projectDtos: List<ProjectDto>,
    @SerialName("title")
    val title: String
)
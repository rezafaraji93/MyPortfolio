package core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface Navigation {
    @Serializable
    @SerialName("home")
    data object HomeScreen : Navigation
    @Serializable
    @SerialName("experience_details")
    data class ExperienceDetailsScreen(val id: String): Navigation
}
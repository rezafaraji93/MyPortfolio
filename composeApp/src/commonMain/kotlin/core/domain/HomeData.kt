package core.domain

data class HomeData(
    val aboutMe: String = "",
    val cvUrl: String = "",
    val experiences: List<Experience> = listOf(),
    val githubUrl: String = "",
    val linkedinUrl: String = "",
    val name: String = "",
    val profilePicture: String = "",
    val projects: List<Project> = listOf(),
    val title: String = ""
)

package core.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExperienceDto(
    @SerialName("app_url")
    val appUrl: String,
    @SerialName("company_linkedin_url")
    val companyLinkedinUrl: String,
    @SerialName("company_logo")
    val companyLogo: String,
    @SerialName("company_name")
    val companyName: String,
    @SerialName("description")
    val description: String,
    @SerialName("summarized_description")
    val summarizedDescription: String,
    @SerialName("about_company")
    val aboutCompany: String,
    @SerialName("id")
    val id: String,
    @SerialName("images")
    val images: List<String>,
    @SerialName("responsibilities")
    val responsibilities: List<String>,
    @SerialName("location")
    val location: String,
    @SerialName("period")
    val period: String,
    @SerialName("title")
    val title: String
)
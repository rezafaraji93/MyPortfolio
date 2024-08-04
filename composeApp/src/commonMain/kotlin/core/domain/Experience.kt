package core.domain

data class Experience(
    val appUrl: String,
    val companyLinkedinUrl: String,
    val companyLogo: String,
    val aboutCompany: String,
    val companyName: String,
    val description: String,
    val summarizedDescription: String,
    val id: String,
    val images: List<String>,
    val responsibilities: List<String>,
    val location: String,
    val period: String,
    val title: String
)

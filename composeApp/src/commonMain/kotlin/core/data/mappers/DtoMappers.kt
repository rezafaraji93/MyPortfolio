package core.data.mappers

import core.data.dto.ExperienceDto
import core.data.dto.HomeResponse
import core.data.dto.ProjectDto
import core.domain.Experience
import core.domain.HomeData
import core.domain.Project

fun HomeResponse.toHomeData(): HomeData =
    HomeData(
        aboutMe = aboutMe,
        cvUrl = cvUrl,
        experiences = experienceDtos.map { it.toExperience() },
        githubUrl = githubUrl,
        linkedinUrl = linkedinUrl,
        name = name,
        profilePicture = profilePicture,
        projects = projectDtos.map { it.toProject() },
        title = title
    )

fun ExperienceDto.toExperience(): Experience = Experience(
    appUrl = appUrl,
    companyLinkedinUrl = companyLinkedinUrl,
    companyLogo = companyLogo,
    companyName = companyName,
    description = description,
    id = id,
    images = images,
    location = location,
    period = period,
    title = title,
    summarizedDescription = summarizedDescription,
    responsibilities = responsibilities,
    aboutCompany = aboutCompany
)

fun ProjectDto.toProject(): Project = Project(
    description = description,
    id = id,
    imageUrl = imageUrl,
    link = link,
    title = title
)
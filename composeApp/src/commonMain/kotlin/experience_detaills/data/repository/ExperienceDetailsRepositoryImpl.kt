package experience_detaills.data.repository

import core.data.dto.ExperienceDto
import core.data.dto.Response
import core.data.mappers.toExperience
import core.data.networking.get
import core.domain.Experience
import core.domain.util.DataError
import core.domain.util.Result
import core.domain.util.map
import experience_detaills.domain.repository.ExperienceDetailsRepository
import io.ktor.client.HttpClient

class ExperienceDetailsRepositoryImpl(
    private val client: HttpClient
): ExperienceDetailsRepository {
    override suspend fun getExperienceDetails(id: String): Result<Experience?, DataError.Network> {
        return client.get<Response<ExperienceDto>>(
            route = "experience/$id"
        ).map {
            it.data?.toExperience()
        }
    }
}
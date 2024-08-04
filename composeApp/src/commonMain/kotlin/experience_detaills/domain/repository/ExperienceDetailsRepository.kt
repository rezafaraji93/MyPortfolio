package experience_detaills.domain.repository

import core.domain.Experience
import core.domain.util.DataError
import core.domain.util.Result

interface ExperienceDetailsRepository {
    suspend fun getExperienceDetails(id: String): Result<Experience?, DataError.Network>
}
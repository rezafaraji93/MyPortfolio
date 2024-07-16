package core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val data: T?,
    val message: String?,
    @SerialName("status_code")
    val statusCode: Int
)
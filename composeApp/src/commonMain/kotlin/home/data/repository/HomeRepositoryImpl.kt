package home.data.repository

import core.data.dto.HomeResponse
import core.data.dto.Response
import core.data.mappers.toHomeData
import core.data.networking.get
import core.domain.HomeData
import core.domain.util.DataError
import core.domain.util.Result
import core.domain.util.map
import home.domain.repository.HomeRepository
import io.ktor.client.HttpClient

class HomeRepositoryImpl(
    private val client: HttpClient
): HomeRepository {
    override suspend fun getHomeDate(): Result<HomeData?, DataError.Network> {
        return client.get<Response<HomeResponse>>(
            route = "home"
        ).map {
            it.data?.toHomeData()
        }
    }
}
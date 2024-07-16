package home.domain.repository

import core.domain.HomeData
import core.domain.util.DataError
import core.domain.util.Result

interface HomeRepository {
    suspend fun getHomeDate(): Result<HomeData?, DataError.Network>
}
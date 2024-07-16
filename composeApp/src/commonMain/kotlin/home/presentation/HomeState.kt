package home.presentation

import core.domain.HomeData

data class HomeState(
    val isLoading: Boolean = true,
    val homeData: HomeData = HomeData()
)

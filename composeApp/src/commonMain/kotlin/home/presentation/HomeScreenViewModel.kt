package home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.BaseState
import core.domain.util.Result
import home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val repository: HomeRepository
) : ViewModel() {

    private val _homeState = MutableStateFlow<BaseState<HomeState>>(BaseState.Loading(HomeState()))
    val homeState = _homeState.asStateFlow()

    init {
        getHomeData()
    }

    private fun getHomeData() {
        viewModelScope.launch {
            when (val result = repository.getHomeDate()) {
                is Result.Error -> {
                    _homeState.update {
                        BaseState.Error(message = "Error occurred! Please try Again")
                    }
                }

                is Result.Success -> {
                    val homeData = result.data ?: return@launch
                    _homeState.update {
                        BaseState.Success(
                            HomeState(
                                homeData = homeData
                            )
                        )
                    }
                }
            }
        }
    }

    fun onRetry() {
        _homeState.update { BaseState.Loading() }
        getHomeData()
    }


}
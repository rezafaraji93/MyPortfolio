package home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.util.Result
import home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val repository: HomeRepository
): ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()

    init {
        getHomeData()
    }

    private fun getHomeData() {
        viewModelScope.launch {
            _homeState.update { it.copy(isLoading = true) }
            val result = repository.getHomeDate()
            _homeState.update { it.copy(isLoading = false) }
            when(result) {
                is Result.Error -> {

                }
                is Result.Success -> {
                    val data = result.data
                    data?.let { homeData ->
                        _homeState.update {
                            it.copy(
                                homeData = homeData
                            )
                        }

                    }
                }
            }
        }
    }


}
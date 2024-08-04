package experience_detaills.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.BaseState
import core.domain.util.Result
import experience_detaills.domain.repository.ExperienceDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ExperienceDetailsViewModel(
    private val repository: ExperienceDetailsRepository,
    private val experienceId: String?
): ViewModel() {

    private val _state = MutableStateFlow<BaseState<ExperienceDetailsState>>(BaseState.Loading())
    val state = _state.asStateFlow()

    init {
        getExperience()
    }

    private fun getExperience() {
        viewModelScope.launch {
            if (experienceId == null) {
                _state.update { BaseState.Error(message = "Experience ID is empty!") }
                return@launch
            }
            when(val data = repository.getExperienceDetails(experienceId)) {
                is Result.Error -> {
                    _state.update {
                        BaseState.Error(message = "Error occurred! Please try Again")
                    }
                }
                is Result.Success -> {
                    val experience = data.data
                    experience?.let { nonNullExperience ->
                        _state.update { BaseState.Success(data = ExperienceDetailsState(experience = nonNullExperience)) }
                    } ?: _state.update { BaseState.Error(message = "Experience Not Found!") }
                }
            }
        }
    }

    fun onRetry() {
        _state.update { BaseState.Loading() }
        getExperience()
    }

}
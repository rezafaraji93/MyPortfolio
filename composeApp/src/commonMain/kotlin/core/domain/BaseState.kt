package core.domain

sealed interface BaseState<T> {
    data class Loading<T>(val data: T? = null) : BaseState<T>
    data class Success<T>(val data: T) : BaseState<T>
    data class Error<T>(val data: T? = null, val message: String? = null) : BaseState<T>
}

package ru.vdh.todo.addtodo.presentation.model

data class AddToDoViewState(
    val isLoading: Boolean = false
) {
    fun loading() = copy(isLoading = true)

    fun idle() = copy(isLoading = false)
}
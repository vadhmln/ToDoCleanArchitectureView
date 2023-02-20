package ru.vdh.todo.addtodo.presentation.model

data class AddToDoViewState(
    val isLoading: Boolean = false,
    val dishDetails: AddToDoPresentationModel? = null
) {
    fun loading() = copy(isLoading = true)

    fun toDoDetailsReady(
        toDoDetails: AddToDoPresentationModel
    ) = copy(dishDetails = toDoDetails, isLoading = false)

    fun idle() = copy(isLoading = false)
}
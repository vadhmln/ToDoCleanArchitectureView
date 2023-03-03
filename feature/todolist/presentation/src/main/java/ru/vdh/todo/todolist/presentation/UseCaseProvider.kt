package ru.vdh.todo.todolist.presentation

import ru.vdh.todo.todolist.domain.usecase.DeleteToDoUseCase
import ru.vdh.todo.todolist.presentation.mapper.ToDoListPresentationToDomainMapper
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import javax.inject.Inject

class UseCaseProvider(
    private val deleteToDoUseCase: DeleteToDoUseCase,
    private val toDoListPresentationToDomainMapper: ToDoListPresentationToDomainMapper,
) {

    fun deleteItem(toDoListPresentationModel: ToDoListPresentationModel) {
        val domainToDo = toDoListPresentationToDomainMapper.toDomain(toDoListPresentationModel)
        deleteToDoUseCase.executeInBackground(domainToDo)
    }
}
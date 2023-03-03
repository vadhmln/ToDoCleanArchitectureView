package ru.vdh.todo.todolist.presentation

import ru.vdh.todo.todolist.domain.usecase.DeleteToDoUseCase
import ru.vdh.todo.todolist.domain.usecase.RestoreDeletedToDoUseCase
import ru.vdh.todo.todolist.presentation.mapper.ToDoListPresentationToDomainMapper
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import javax.inject.Inject

class UseCaseProvider(
    private val deleteToDoUseCase: DeleteToDoUseCase,
    private val restoreDeletedToDoUseCase: RestoreDeletedToDoUseCase,
    private val toDoListPresentationToDomainMapper: ToDoListPresentationToDomainMapper,
) {

    fun deleteItem(toDoListPresentationModel: ToDoListPresentationModel) {
        val domainToDo = toDoListPresentationToDomainMapper.toDomain(toDoListPresentationModel)
        deleteToDoUseCase.executeInBackground(domainToDo)
    }

    fun restoreDeletedToDo(addToDoPresentationModel: ToDoListPresentationModel) {
        val domainToDo = toDoListPresentationToDomainMapper.toDomain(addToDoPresentationModel)
        restoreDeletedToDoUseCase.executeInBackground(domainToDo)
    }
}
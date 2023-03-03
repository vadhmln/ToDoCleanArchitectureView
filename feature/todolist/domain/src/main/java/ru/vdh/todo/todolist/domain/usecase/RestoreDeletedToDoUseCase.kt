package ru.vdh.todo.todolist.domain.usecase

import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository

class RestoreDeletedToDoUseCase(
    private val toDoListRepository: ToDoListRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<ToDoListDomainModel, Unit>(coroutineContextProvider) {

    override fun executeInBackground(request: ToDoListDomainModel) {
        toDoListRepository.addToDo(toDoListDomainModel = request)
    }
}




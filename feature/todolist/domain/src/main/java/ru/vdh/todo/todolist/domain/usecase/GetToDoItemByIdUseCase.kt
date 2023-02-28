package ru.vdh.todo.todolist.domain.usecase

import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository

class GetToDoItemByIdUseCase(
    private val toDoListRepository: ToDoListRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, ToDoListDomainModel>(
    coroutineContextProvider
) {

    override fun executeInBackground(request: Int) =
        toDoListRepository.getItemById(request)
}
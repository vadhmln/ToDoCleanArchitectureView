package ru.vdh.todo.todolist.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository

class GetToDoListUseCase(
    private val toDoListRepository: ToDoListRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Flow<List<ToDoListDomainModel>>, Flow<List<ToDoListDomainModel>>>(
    coroutineContextProvider
) {

    override fun executeInBackground(request: Flow<List<ToDoListDomainModel>>) =
        toDoListRepository.getAllData()
}
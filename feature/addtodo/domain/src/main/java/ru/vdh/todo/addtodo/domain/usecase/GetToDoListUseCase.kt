package ru.vdh.todo.addtodo.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel
import ru.vdh.todo.addtodo.domain.repository.AddToDoRepository

class GetToDoListUseCase(
    private val addToDoRepository: AddToDoRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Flow<List<AddToDoDomainModel>>, Flow<List<AddToDoDomainModel>>>(
    coroutineContextProvider
) {

    override fun executeInBackground(request: Flow<List<AddToDoDomainModel>>) =
        addToDoRepository.getAllData()
}
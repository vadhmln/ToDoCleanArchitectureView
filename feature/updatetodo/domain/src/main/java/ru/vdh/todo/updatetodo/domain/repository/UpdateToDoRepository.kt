package ru.vdh.todo.updatetodo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

interface UpdateToDoRepository {

    fun updateToDo(updateToDoDomainModel: UpdateToDoDomainModel)

    fun deleteToDo(updateToDoDomainModel: UpdateToDoDomainModel)

    fun getItemById(toDoId: Int): Flow<UpdateToDoDomainModel>
}
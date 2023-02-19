package ru.vdh.todo.addtodo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel

interface AddToDoRepository {

    fun getAllData(): Flow<List<AddToDoDomainModel>>

    fun addToDo(addToDoDomainModel: AddToDoDomainModel): Boolean

}
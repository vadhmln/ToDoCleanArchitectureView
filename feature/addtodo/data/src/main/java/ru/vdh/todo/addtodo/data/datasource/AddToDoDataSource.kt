package ru.vdh.todo.addtodo.data.datasource

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.addtodo.data.model.AddToDoDataModel

interface AddToDoDataSource {

    fun getAllData(): Flow<List<AddToDoDataModel>>

    fun addToDo(addToDoDataModel: AddToDoDataModel)
}
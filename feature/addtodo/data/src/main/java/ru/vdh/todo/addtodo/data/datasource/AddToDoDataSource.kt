package ru.vdh.todo.addtodo.data.datasource

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.addtodo.data.model.AddToDoDataModel

interface AddToDoDataSource {

    fun addToDo(addToDoDataModel: AddToDoDataModel)
}
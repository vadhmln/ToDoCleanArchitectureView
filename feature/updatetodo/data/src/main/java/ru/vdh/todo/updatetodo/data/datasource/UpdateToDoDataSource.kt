package ru.vdh.todo.updatetodo.data.datasource

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel

interface UpdateToDoDataSource {

    fun updateToDo(updateToDoDataModel: UpdateToDoDataModel)

    fun deleteToDo(updateToDoDataModel: UpdateToDoDataModel)

    fun getItemById(toDoId: Int): Flow<UpdateToDoDataModel?>
}
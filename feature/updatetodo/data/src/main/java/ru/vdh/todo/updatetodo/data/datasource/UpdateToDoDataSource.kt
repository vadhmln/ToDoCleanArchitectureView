package ru.vdh.todo.updatetodo.data.datasource

import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel

interface UpdateToDoDataSource {

    fun updateToDo(addToDoDataModel: UpdateToDoDataModel)
}
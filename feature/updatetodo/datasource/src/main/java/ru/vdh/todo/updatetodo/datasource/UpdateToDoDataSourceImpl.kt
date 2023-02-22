package ru.vdh.todo.updatetodo.datasource

import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource

class UpdateToDoDataSourceImpl(
    private val toDoDao: ToDoDao,
) : UpdateToDoDataSource {


}
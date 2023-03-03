package ru.vdh.todo.todolist.data.datasource

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.todolist.data.model.ToDoListDataModel

interface ToDoListDataSource {

    fun getAllData(): Flow<List<ToDoListDataModel>>

    fun deleteToDo(toDoListDataModel: ToDoListDataModel)

    fun deleteAll()
}
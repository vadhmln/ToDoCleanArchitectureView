package ru.vdh.todo.todolist.data.datasource

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.todolist.data.model.ToDoListDataModel
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel

interface ToDoListDataSource {

    fun getAllData(): Flow<List<ToDoListDataModel>>

    fun deleteToDo(toDoListDataModel: ToDoListDataModel)

    fun deleteAll()

    fun addToDo(toDoListDataModel: ToDoListDataModel)

    fun searchDatabase(searchQuery: String): Flow<List<ToDoListDataModel>>

    fun sortByHighPriority(): Flow<List<ToDoListDataModel>>

    fun sortByLowPriority(): Flow<List<ToDoListDataModel>>
}
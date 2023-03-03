package ru.vdh.todo.todolist.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel

interface ToDoListRepository {

    fun getAllData(): Flow<List<ToDoListDomainModel>>

    fun deleteToDo(toDoListDomainModel: ToDoListDomainModel)

    fun deleteAll()

    fun addToDo(toDoListDomainModel: ToDoListDomainModel)
}
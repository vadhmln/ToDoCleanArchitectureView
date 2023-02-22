package ru.vdh.todo.addtodo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel

interface AddToDoRepository {

    fun addToDo(addToDoDomainModel: AddToDoDomainModel)
}
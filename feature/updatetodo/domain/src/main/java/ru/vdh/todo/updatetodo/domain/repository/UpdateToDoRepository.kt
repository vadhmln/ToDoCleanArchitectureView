package ru.vdh.todo.updatetodo.domain.repository

import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

interface UpdateToDoRepository {

    fun updateToDo(updateToDoDomainModel: UpdateToDoDomainModel)

    fun deleteToDo(updateToDoDomainModel: UpdateToDoDomainModel)
}
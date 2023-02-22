package ru.vdh.todo.todolist.data.mapper

import ru.vdh.todo.todolist.data.model.ToDoListDataModel
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel

class ToDoListDomainToDataMapper {

    fun toData(addToDoDomainModel: ToDoListDomainModel) =
        ToDoListDataModel(
            id = addToDoDomainModel.id,
            title = addToDoDomainModel.title,
            priority = addToDoDomainModel.priority,
            description = addToDoDomainModel.description
        )
}
package ru.vdh.todo.todolist.data.mapper

import ru.vdh.todo.todolist.data.model.ToDoListDataModel
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel

class ToDoListDataToDomainMapper {

    fun toDomain(addToDoDataModel: ToDoListDataModel) =
        ToDoListDomainModel(
            id = addToDoDataModel.id,
            title = addToDoDataModel.title,
            priority = addToDoDataModel.priority,
            description = addToDoDataModel.description
        )
}
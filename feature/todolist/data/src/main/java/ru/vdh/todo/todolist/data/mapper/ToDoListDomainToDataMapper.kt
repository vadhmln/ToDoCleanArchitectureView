package ru.vdh.todo.todolist.data.mapper

import ru.vdh.todo.todolist.data.model.ToDoListDataModel
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel

class ToDoListDomainToDataMapper {

    fun toData(input: ToDoListDomainModel) =
        ToDoListDataModel(
            date = input.date,
            id = input.id,
            title = input.title,
            priority = input.priority,
            description = input.description
        )
}
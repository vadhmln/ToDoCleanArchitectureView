package ru.vdh.todo.todolist.presentation.mapper

import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel

class ToDoListPresentationToDomainMapper {
    fun toDomain(input: ToDoListPresentationModel) =
        ToDoListDomainModel(
            date = input.date,
            id = input.id,
            title = input.title,
            priority = input.priority,
            description = input.description
        )
}

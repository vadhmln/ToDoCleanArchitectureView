package ru.vdh.todo.todolist.presentation.mapper

import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel

class ToDoListPresentationToDomainMapper {
    fun toDomain(newToDo: ToDoListPresentationModel) =
        ToDoListDomainModel(
            id = newToDo.id,
            title = newToDo.title,
            priority = newToDo.priority,
            description = newToDo.description
        )
}

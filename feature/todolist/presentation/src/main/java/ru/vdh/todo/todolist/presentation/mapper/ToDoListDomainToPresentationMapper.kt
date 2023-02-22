package ru.vdh.todo.todolist.presentation.mapper

import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel

class ToDoListDomainToPresentationMapper {
    fun toPresentation(newToDo: ToDoListDomainModel) =
        ToDoListPresentationModel(
            id = newToDo.id,
            title = newToDo.title,
            priority = newToDo.priority,
            description = newToDo.description
        )
}
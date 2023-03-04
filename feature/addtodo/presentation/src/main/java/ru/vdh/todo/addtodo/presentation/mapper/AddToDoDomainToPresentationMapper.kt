package ru.vdh.todo.addtodo.presentation.mapper

import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel
import ru.vdh.todo.addtodo.presentation.model.AddToDoPresentationModel

class AddToDoDomainToPresentationMapper {
    fun toPresentation(newToDo: AddToDoDomainModel) =
        AddToDoPresentationModel(
            date = newToDo.date,
            id = newToDo.id,
            title = newToDo.title,
            priority = newToDo.priority,
            description = newToDo.description
        )
}
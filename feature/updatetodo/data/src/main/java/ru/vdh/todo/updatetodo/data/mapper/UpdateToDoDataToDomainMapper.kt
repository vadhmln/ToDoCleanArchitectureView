package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

class UpdateToDoDataToDomainMapper {

    fun toDomain(input: UpdateToDoDataModel?) =
        input?.let {
            UpdateToDoDomainModel(
                date = input.date,
                id = it.id,
                title = input.title,
                priority = input.priority,
                description = input.description
            )
        }
}
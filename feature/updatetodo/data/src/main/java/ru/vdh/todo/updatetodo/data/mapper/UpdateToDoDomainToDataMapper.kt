package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

class UpdateToDoDomainToDataMapper {

    fun toData(input: UpdateToDoDomainModel) =
        UpdateToDoDataModel(
            date = input.date,
            id = input.id,
            title = input.title,
            priority = input.priority,
            description = input.description
        )
}
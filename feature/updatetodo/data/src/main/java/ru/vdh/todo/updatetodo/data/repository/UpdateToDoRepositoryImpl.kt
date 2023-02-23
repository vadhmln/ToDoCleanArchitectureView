package ru.vdh.todo.updatetodo.data.repository

import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDomainToDataMapper
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository

class UpdateToDoRepositoryImpl(
    private val updateToDoDataSource: UpdateToDoDataSource,
    private val updateToDoDomainToDataMapper: UpdateToDoDomainToDataMapper,
) : UpdateToDoRepository {

    override fun updateToDo(updateToDoDomainModel: UpdateToDoDomainModel) {
        val updateToDoDataModel = updateToDoDomainToDataMapper.toData(updateToDoDomainModel)
        updateToDoDataSource.updateToDo(updateToDoDataModel)
    }

    override fun deleteToDo(updateToDoDomainModel: UpdateToDoDomainModel) {
        val updateToDoDataModel = updateToDoDomainToDataMapper.toData(updateToDoDomainModel)
        updateToDoDataSource.deleteToDo(updateToDoDataModel)
    }
}



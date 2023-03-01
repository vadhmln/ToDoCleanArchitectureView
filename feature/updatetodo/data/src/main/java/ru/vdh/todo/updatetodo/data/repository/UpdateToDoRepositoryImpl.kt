package ru.vdh.todo.updatetodo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataToDomainMapper
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDomainToDataMapper
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository

class UpdateToDoRepositoryImpl(
    private val updateToDoDataSource: UpdateToDoDataSource,
    private val updateToDoDomainToDataMapper: UpdateToDoDomainToDataMapper,
    private val updateToDoDataToDomainMapper: UpdateToDoDataToDomainMapper,
) : UpdateToDoRepository {

    override fun updateToDo(updateToDoDomainModel: UpdateToDoDomainModel) {
        val updateToDoDataModel = updateToDoDomainToDataMapper.toData(updateToDoDomainModel)
        updateToDoDataSource.updateToDo(updateToDoDataModel)
    }

    override fun deleteToDo(updateToDoDomainModel: UpdateToDoDomainModel) {
        val updateToDoDataModel = updateToDoDomainToDataMapper.toData(updateToDoDomainModel)
        updateToDoDataSource.deleteToDo(updateToDoDataModel)
    }

    override fun getItemById(toDoId: Int): Flow<UpdateToDoDomainModel> {
        return updateToDoDataSource.getItemById(toDoId).map(updateToDoDataToDomainMapper::toDomain)
    }
}



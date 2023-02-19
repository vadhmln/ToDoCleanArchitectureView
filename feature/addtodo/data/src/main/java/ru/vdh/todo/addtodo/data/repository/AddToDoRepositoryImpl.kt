package ru.vdh.todo.addtodo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.data.mapper.AddToDoDataToDomainMapper
import ru.vdh.todo.addtodo.data.mapper.AddToDoDomainToDataMapper
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel
import ru.vdh.todo.addtodo.domain.repository.AddToDoRepository

class AddToDoRepositoryImpl(
    private val addToDoDataSource: AddToDoDataSource,
    private val addToDoDomainToDataMapper: AddToDoDomainToDataMapper,
    private val addToDoDataToDomainMapper: AddToDoDataToDomainMapper,
) : AddToDoRepository {

    override fun getAllData(): Flow<List<AddToDoDomainModel>> {
        return addToDoDataSource.getAllData().map { it ->
            it.map {
                addToDoDataToDomainMapper.toDomain(it)
            }
        }
    }

    override fun addToDo(addToDoDomainModel: AddToDoDomainModel): Boolean {
        val addToDoDataModel = addToDoDomainToDataMapper.toData(addToDoDomainModel)
        return addToDoDataSource.addToDo(addToDoDataModel)
    }
}



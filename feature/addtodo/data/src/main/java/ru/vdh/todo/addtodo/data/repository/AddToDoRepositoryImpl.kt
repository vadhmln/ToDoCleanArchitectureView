package ru.vdh.todo.addtodo.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.data.mapper.AddToDoDataToDomainMapper
import ru.vdh.todo.addtodo.data.mapper.AddToDoDomainToDataMapper
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel
import ru.vdh.todo.addtodo.domain.repository.AddToDoRepository
import javax.inject.Inject

class AddToDoRepositoryImpl(
    private val addToDoDataSource: AddToDoDataSource,
    private val addToDoDomainToDataMapper: AddToDoDomainToDataMapper,
) : AddToDoRepository {

    override fun addToDo(addToDoDomainModel: AddToDoDomainModel) {
//        addToDoDataSource.insert()
        val addToDoDataModel = addToDoDomainToDataMapper.toData(addToDoDomainModel)
        addToDoDataSource.addToDo(addToDoDataModel)
    }
}



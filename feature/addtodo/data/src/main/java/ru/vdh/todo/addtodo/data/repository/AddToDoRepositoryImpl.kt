package ru.vdh.todo.addtodo.data.repository

import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.data.mapper.AddToDoDomainToDataMapper
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel
import ru.vdh.todo.addtodo.domain.repository.AddToDoRepository

class AddToDoRepositoryImpl(
    private val addToDoDataSource: AddToDoDataSource,
    private val addToDoDomainToDataMapper: AddToDoDomainToDataMapper,
) : AddToDoRepository {

    override fun addToDo(addToDoDomainModel: AddToDoDomainModel) {
        val addToDoDataModel = addToDoDomainToDataMapper.toData(addToDoDomainModel)
        addToDoDataSource.addToDo(addToDoDataModel)
    }
}



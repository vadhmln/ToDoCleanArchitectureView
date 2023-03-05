package ru.vdh.todo.todolist.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.todolist.data.datasource.ToDoListDataSource
import ru.vdh.todo.todolist.data.mapper.ToDoListDataToDomainMapper
import ru.vdh.todo.todolist.data.mapper.ToDoListDomainToDataMapper
import ru.vdh.todo.todolist.data.model.ToDoListDataModel
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository

class ToDoListRepositoryImpl(
    private val toDoListDataSource: ToDoListDataSource,
    private val toDoListDataToDomainMapper: ToDoListDataToDomainMapper,
    private val toDoListDomainToDataMapper: ToDoListDomainToDataMapper
) : ToDoListRepository {

    override fun getAllData(): Flow<List<ToDoListDomainModel>> =
        toDoListDataSource.getAllData().map { it ->
            it.map {
                toDoListDataToDomainMapper.toDomain(it)
            }
        }


    override fun deleteToDo(toDoListDomainModel: ToDoListDomainModel) {
        val updateToDoDataModel = toDoListDomainToDataMapper.toData(toDoListDomainModel)
        toDoListDataSource.deleteToDo(updateToDoDataModel)
    }

    override fun deleteAll() {
        toDoListDataSource.deleteAll()
    }

    override fun addToDo(toDoListDomainModel: ToDoListDomainModel) {
        val addToDoDataModel = toDoListDomainToDataMapper.toData(toDoListDomainModel)
        toDoListDataSource.addToDo(addToDoDataModel)
    }

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoListDomainModel>> =
        toDoListDataSource.searchDatabase(searchQuery).map { list ->
            list.map {
                toDoListDataToDomainMapper.toDomain(it)
            }
        }
}



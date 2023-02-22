package ru.vdh.todo.todolist.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.todolist.data.datasource.ToDoListDataSource
import ru.vdh.todo.todolist.data.mapper.ToDoListDataToDomainMapper
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository

class ToDoListRepositoryImpl(
    private val toDoListDataSource: ToDoListDataSource,
    private val toDoListDataToDomainMapper: ToDoListDataToDomainMapper,
) : ToDoListRepository {

    override fun getAllData(): Flow<List<ToDoListDomainModel>> {
        return toDoListDataSource.getAllData().map { it ->
            it.map {
                toDoListDataToDomainMapper.toDomain(it)
            }
        }
    }

}



package ru.vdh.todo.todolist.data.repository

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
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



package ru.vdh.todo.todolist.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.todolist.data.datasource.ToDoListDataSource
import ru.vdh.todo.todolist.data.model.ToDoListDataModel
import ru.vdh.todo.todolist.datasource.mapper.DataBaseToToDoListDataMapper

class ToDoListDataSourceImpl(
    private val dataBaseToToDoListDataMapper: DataBaseToToDoListDataMapper,
    private val toDoDao: ToDoDao,
) : ToDoListDataSource {

    override fun getAllData(): Flow<List<ToDoListDataModel>> {
        return toDoDao.getAllData().map { it ->
            it.map {
                dataBaseToToDoListDataMapper.toData(it)
            }
        }
    }

    override fun getItemById(toDoId: Int): ToDoListDataModel {
        return dataBaseToToDoListDataMapper.toData(toDoDao.getItemById(toDoId))
    }
}
package ru.vdh.todo.todolist.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.todolist.data.datasource.ToDoListDataSource
import ru.vdh.todo.todolist.data.model.ToDoListDataModel
import ru.vdh.todo.todolist.datasource.mapper.DataBaseToToDoListDataMapper
import ru.vdh.todo.todolist.datasource.mapper.ToDoListDataToDataBaseMapper

class ToDoListDataSourceImpl(
    private val dataBaseToToDoListDataMapper: DataBaseToToDoListDataMapper,
    private val toDoListDataToDataBaseMapper: ToDoListDataToDataBaseMapper,
    private val toDoDao: ToDoDao,
) : ToDoListDataSource {

    override fun getAllData(): Flow<List<ToDoListDataModel>> =
        toDoDao.getAllData().map { list ->
            list.map {
                dataBaseToToDoListDataMapper.toData(it)
            }
        }

    override fun deleteToDo(toDoListDataModel: ToDoListDataModel) {
        val dataBaseToDo = toDoListDataToDataBaseMapper.toDataBase(toDoListDataModel)
        toDoDao.deleteItem(dataBaseToDo)
    }

    override fun deleteAll() {
        toDoDao.deleteAll()
    }

    override fun addToDo(toDoListDataModel: ToDoListDataModel) {
        val dataBaseToDo = toDoListDataToDataBaseMapper.toDataBase(toDoListDataModel)
        toDoDao.insertData(dataBaseToDo)
    }
}
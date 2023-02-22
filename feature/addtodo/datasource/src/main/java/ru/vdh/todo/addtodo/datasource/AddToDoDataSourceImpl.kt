package ru.vdh.todo.addtodo.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.data.model.AddToDoDataModel
import ru.vdh.todo.addtodo.datasource.mapper.DataBaseToAddToDoDataMapper
import ru.vdh.todo.addtodo.datasource.mapper.AddToDoDataToDataBaseMapper
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.database_local.util.Converter

class AddToDoDataSourceImpl(
    private val addToDoDataToDataBaseMapper: AddToDoDataToDataBaseMapper,
    private val toDoDao: ToDoDao,
) : AddToDoDataSource {

    override fun addToDo(addToDoDataModel: AddToDoDataModel) {
        val dataBaseToDo = addToDoDataToDataBaseMapper.toDataBase(addToDoDataModel)
        toDoDao.insertData(dataBaseToDo)
    }
}
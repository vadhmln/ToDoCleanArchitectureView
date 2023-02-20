package ru.vdh.todo.addtodo.datasource

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.data.model.AddToDoDataModel
import ru.vdh.todo.addtodo.datasource.mapper.DataBaseToDataMapper
import ru.vdh.todo.addtodo.datasource.mapper.DataToDataBaseMapper
import ru.vdh.todo.database_local.ToDoDataBase
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.database_local.util.Converter

class AddToDoDataSourceImpl(
    private val dataToDataBaseMapper: DataToDataBaseMapper,
    private val dataBaseToDataMapper: DataBaseToDataMapper,
    private val converter: Converter,
    private val toDoDao: ToDoDao,
) : AddToDoDataSource {

//    private val toDoDao = ToDoDataBase.getDatabase(application).toDoDao()

    override fun getAllData(): Flow<List<AddToDoDataModel>> {
        return toDoDao.getAllData().map { it ->
            it.map {
                dataBaseToDataMapper.toData(it, converter)
            }
        }
    }

    override fun addToDo(addToDoDataModel: AddToDoDataModel): Boolean {
        val dataBaseToDo = dataToDataBaseMapper.toDataBase(addToDoDataModel)
        toDoDao.insertData(dataBaseToDo)
        return true
    }
}
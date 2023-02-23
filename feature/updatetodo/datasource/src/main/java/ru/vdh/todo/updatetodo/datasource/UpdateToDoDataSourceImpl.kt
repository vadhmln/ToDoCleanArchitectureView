package ru.vdh.todo.updatetodo.datasource

import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel
import ru.vdh.todo.updatetodo.datasource.mapper.UpdateToDoDataToDataBaseMapper

class UpdateToDoDataSourceImpl(
    private val updateToDoDataToDataBaseMapper: UpdateToDoDataToDataBaseMapper,
    private val toDoDao: ToDoDao,
) : UpdateToDoDataSource {

    override fun updateToDo(updateToDoDataModel: UpdateToDoDataModel) {
        val dataBaseToDo = updateToDoDataToDataBaseMapper.toDataBase(updateToDoDataModel)
        toDoDao.updateData(dataBaseToDo)
    }

    override fun deleteToDo(updateToDoDataModel: UpdateToDoDataModel) {
        val dataBaseToDo = updateToDoDataToDataBaseMapper.toDataBase(updateToDoDataModel)
        toDoDao.deleteItem(dataBaseToDo)
    }
}
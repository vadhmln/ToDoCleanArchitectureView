package ru.vdh.todo.database_local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): Flow<List<ToDoLocalDataBaseModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(toDoLocalDataBaseModel: ToDoLocalDataBaseModel)
}
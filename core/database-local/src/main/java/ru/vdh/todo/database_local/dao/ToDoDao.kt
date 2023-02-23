package ru.vdh.todo.database_local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): Flow<List<ToDoLocalDataBaseModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(toDoLocalDataBaseModel: ToDoLocalDataBaseModel)

    @Update
    fun updateData(toDoData: ToDoLocalDataBaseModel)

    @Delete
    fun deleteItem(toDoData: ToDoLocalDataBaseModel)

    @Query("DELETE FROM todo_table")
    fun deleteAll()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoLocalDataBaseModel>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoLocalDataBaseModel>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoLocalDataBaseModel>>
}
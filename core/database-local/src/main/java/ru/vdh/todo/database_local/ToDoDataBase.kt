package ru.vdh.todo.database_local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.database_local.util.Converter

@Database(entities = [ToDoLocalDataBaseModel::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDataBase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {

        @Volatile
        private var INSTANCE: ToDoDataBase? = null

        fun getDatabase(context: Context): ToDoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDataBase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

//    companion object {
//        @Volatile
//        private var INSTANCE: ToDoDataBase? = null
//
//        fun getDatabase(context: Context): ToDoDataBase =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE
//                    ?: buildDatabase(context).also { INSTANCE = it }
//            }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                ToDoDataBase::class.java, "todo_database"
//            ).build()
//    }
}
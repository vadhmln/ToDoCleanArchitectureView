package ru.vdh.todo.app.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.database_local.ToDoDataBase
import ru.vdh.todo.database_local.dao.ToDoDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AddToDoDatabaseModule {

    @Provides
    fun providesToDoDao(toDoDataBase: ToDoDataBase,): ToDoDao = toDoDataBase.toDoDao()

//    @Provides
//    @Singleton
//    fun providesToDoDataBase(
//        @ApplicationContext context: Context,
//    ): ToDoDataBase = ToDoDataBase.getDatabase(context)

    @Provides
    @Singleton
    fun providesToDoDataBase(
        @ApplicationContext context: Context,
    ): ToDoDataBase = Room.databaseBuilder(
        context,
        ToDoDataBase::class.java,
        "todo-database"
    ).build()
}
package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.todolist.data.datasource.ToDoListDataSource
import ru.vdh.todo.todolist.datasource.ToDoListDataSourceImpl
import ru.vdh.todo.todolist.datasource.mapper.DataBaseToToDoListDataMapper
import ru.vdh.todo.todolist.datasource.mapper.ToDoListDataToDataBaseMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ToDoListDataSourceModule {

    @Provides
    fun providesDataBaseToToDoListDataMapper() = DataBaseToToDoListDataMapper()

    @Provides
    fun providesToDoListDataToDataBaseMapper() = ToDoListDataToDataBaseMapper()

    @Provides
    @Singleton
    fun provideAddToDoDataSource(
        dataBaseToToDoListDataMapper: DataBaseToToDoListDataMapper,
        toDoListDataToDataBaseMapper: ToDoListDataToDataBaseMapper,
        toDoDao: ToDoDao,
    ): ToDoListDataSource = ToDoListDataSourceImpl(
        dataBaseToToDoListDataMapper,
        toDoListDataToDataBaseMapper,
        toDoDao,
    )
}
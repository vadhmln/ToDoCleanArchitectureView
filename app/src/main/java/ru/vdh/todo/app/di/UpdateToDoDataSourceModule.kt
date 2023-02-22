package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.datasource.UpdateToDoDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UpdateToDoDataSourceModule {

    @Provides
    @Singleton
    fun provideAddToDoDataSource(
        toDoDao: ToDoDao,
    ): UpdateToDoDataSource = UpdateToDoDataSourceImpl(
        toDoDao,
    )
}
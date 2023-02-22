package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.datasource.AddToDoDataSourceImpl
import ru.vdh.todo.addtodo.datasource.mapper.AddToDoDataToDataBaseMapper
import ru.vdh.todo.addtodo.datasource.mapper.DataBaseToAddToDoDataMapper
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.database_local.util.Converter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AddToDoDataSourceModule {

    @Provides
    fun providesDataBaseToAddToDoDataMapper() = DataBaseToAddToDoDataMapper()

    @Provides
    fun providesDataToDataBaseMapper() = AddToDoDataToDataBaseMapper()

    @Provides
    fun providesConverter() = Converter()

    @Provides
    @Singleton
    fun provideAddToDoDataSource(
        addToDoDataToDataBaseMapper: AddToDoDataToDataBaseMapper,
        toDoDao: ToDoDao,
    ): AddToDoDataSource = AddToDoDataSourceImpl(
        addToDoDataToDataBaseMapper,
        toDoDao,
    )
}
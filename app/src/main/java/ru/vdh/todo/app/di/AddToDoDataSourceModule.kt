package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.datasource.AddToDoDataSourceImpl
import ru.vdh.todo.addtodo.datasource.mapper.DataBaseToDataMapper
import ru.vdh.todo.addtodo.datasource.mapper.DataToDataBaseMapper
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.database_local.util.Converter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AddToDoDataSourceModule {

    @Provides
    fun providesDataBaseToDataMapper() = DataBaseToDataMapper()

    @Provides
    fun providesDataToDataBaseMapper() = DataToDataBaseMapper()

    @Provides
    fun providesConverter() = Converter()

    @Provides
    @Singleton
    fun provideAddToDoDataSource(
        dataToDataBaseMapper: DataToDataBaseMapper,
        dataBaseToDataMapper: DataBaseToDataMapper,
        converter: Converter,
        toDoDao: ToDoDao,
    ): AddToDoDataSource = AddToDoDataSourceImpl(
        dataToDataBaseMapper,
        dataBaseToDataMapper,
        converter,
        toDoDao,
    )
}
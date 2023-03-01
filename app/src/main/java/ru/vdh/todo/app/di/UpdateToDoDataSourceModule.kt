package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.database_local.dao.ToDoDao
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.datasource.UpdateToDoDataSourceImpl
import ru.vdh.todo.updatetodo.datasource.mapper.DataBaseToUpdateToDoDataMapper
import ru.vdh.todo.updatetodo.datasource.mapper.UpdateToDoDataToDataBaseMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UpdateToDoDataSourceModule {

    @Provides
    fun providesUpdateToDoDataToDataBaseMapper() = UpdateToDoDataToDataBaseMapper()

    @Provides
    fun providesDataBaseToUpdateToDoDataMapper() = DataBaseToUpdateToDoDataMapper()

    @Provides
    @Singleton
    fun provideUpdateToDoDataSource(
        updateToDoDataToDataBaseMapper: UpdateToDoDataToDataBaseMapper,
        dataBaseToUpdateToDoDataMapper: DataBaseToUpdateToDoDataMapper,
        toDoDao: ToDoDao,
    ): UpdateToDoDataSource = UpdateToDoDataSourceImpl(
        updateToDoDataToDataBaseMapper,
        dataBaseToUpdateToDoDataMapper,
        toDoDao,
    )
}
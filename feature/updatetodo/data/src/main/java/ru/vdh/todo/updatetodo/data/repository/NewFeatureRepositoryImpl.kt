package ru.vdh.todo.updatetodo.data.repository

import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataModelToDataSourceMapper
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataModelToDomainMapper
import ru.vdh.todo.updatetodo.domain.repository.NewFeatureRepository

class NewFeatureRepositoryImpl(
    private val updateToDoDataSource: UpdateToDoDataSource,
    private val updateToDoDataModelToDomainMapper: UpdateToDoDataModelToDomainMapper,
    private val updateToDoDataModelToDataSourceMapper: UpdateToDoDataModelToDataSourceMapper
) : NewFeatureRepository {


}



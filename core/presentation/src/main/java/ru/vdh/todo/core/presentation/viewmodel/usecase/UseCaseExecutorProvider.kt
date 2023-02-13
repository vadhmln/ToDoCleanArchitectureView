package ru.vdh.todo.core.presentation.viewmodel.usecase

import kotlinx.coroutines.CoroutineScope
import ru.vdh.todo.core.domain.usecase.UseCaseExecutor

typealias UseCaseExecutorProvider =
    @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> UseCaseExecutor

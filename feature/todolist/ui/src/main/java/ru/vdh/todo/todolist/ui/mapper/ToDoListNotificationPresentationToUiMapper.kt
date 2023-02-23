package ru.vdh.todo.todolist.ui.mapper

import ru.vdh.todo.core.ui.mapper.NotificationPresentationToUiMapper
import ru.vdh.todo.core.ui.model.NotificationUiModel
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationNotification

class ToDoListNotificationPresentationToUiMapper :
    NotificationPresentationToUiMapper<ToDoListPresentationNotification> {
    override fun toUi(
        presentationNotification: ToDoListPresentationNotification
    ): NotificationUiModel {
        throw IllegalStateException("Notifications not supported.")
    }
}

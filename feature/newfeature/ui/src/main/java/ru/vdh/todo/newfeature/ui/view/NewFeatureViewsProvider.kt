package ru.vdh.todo.newfeature.ui.view

import android.view.View
import android.widget.EditText
import android.widget.TextView
import ru.vdh.todo.core.ui.view.ViewsProvider

interface NewFeatureViewsProvider : ViewsProvider {
    val userNameField: TextView
    val dataEditView: EditText
    val getUserNameButton: View
    val saveUserNameButton: View
    val secondFragmentButton: View
}

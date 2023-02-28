package ru.vdh.todo.app.di

import androidx.recyclerview.widget.RecyclerView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.todolist.ui.adapter.DelegateOnClickListener
import ru.vdh.todo.todolist.ui.adapter.ToDoListAdapter

@Module
@InstallIn(SingletonComponent::class)
interface ToDoListAppNavigationModule {

    @Binds
    fun providesOnClickListener(delegateOnClickListener: DelegateOnClickListener) : ToDoListAdapter.OnClickListener

    @Binds
    fun providesRecyclerViewViewHolder(myViewHolder: ToDoListAdapter.MyViewHolder) : RecyclerView.ViewHolder

}
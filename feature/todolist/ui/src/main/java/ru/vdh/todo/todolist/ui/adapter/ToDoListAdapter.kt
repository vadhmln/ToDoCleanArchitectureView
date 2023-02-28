package ru.vdh.todo.todolist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import ru.vdh.todo.core.ui.R
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToDoListAdapter @Inject constructor() : RecyclerView.Adapter<ToDoListAdapter.MyViewHolder>() {

    private val delegateOnClickListener = DelegateOnClickListener()

    var onToDoItemClickListener: OnClickListener = delegateOnClickListener.onToDoItemClickListener

    private var dataList = emptyList<ToDoListPresentationModel>()

    class MyViewHolder @Inject constructor(
        private val onClickListener: OnClickListener,
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val title: TextView by lazy { itemView.findViewById(ru.vdh.todo.todolist.ui.R.id.title_txt) }
        val description: TextView by lazy { itemView.findViewById(ru.vdh.todo.todolist.ui.R.id.description_txt) }
        val priorityIndicator: MaterialCardView by lazy { itemView.findViewById(ru.vdh.todo.todolist.ui.R.id.priority_indicator) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        LayoutInflater.from(parent.context)
            .inflate(ru.vdh.todo.todolist.ui.R.layout.row_layout, parent, false)
            .let { view -> MyViewHolder(delegateOnClickListener, view) }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = dataList[position].title
        holder.description.text = dataList[position].description
        holder.itemView.setOnClickListener {

            onToDoItemClickListener.onToDoItemClick(dataList[position])
        }

        when (dataList[position].priority) {
            "High priority" -> holder.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.red
                )
            )

            "Medium priority" -> holder.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.yellow
                )
            )

            "Low priority" -> holder.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.green
                )
            )
        }
    }

    fun setData(toDoData: List<ToDoListPresentationModel>) {
        val toDoDiffUtil = ToDoDiffUtil(dataList, toDoData)
        val toDoDiffResult = DiffUtil.calculateDiff(toDoDiffUtil)
        this.dataList = toDoData
        toDoDiffResult.dispatchUpdatesTo(this)
    }

    interface OnClickListener {
        fun onToDoItemClick(currentItem: ToDoListPresentationModel)

        object DoNothing : OnClickListener {
            override fun onToDoItemClick(currentItem: ToDoListPresentationModel) = Unit
        }
    }
}
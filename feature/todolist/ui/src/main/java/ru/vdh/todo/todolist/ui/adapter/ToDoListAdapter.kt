package ru.vdh.todo.todolist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.vdh.todo.NavGraphDirections
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import ru.vdh.todo.todolist.ui.databinding.RowLayoutBinding

class ToDoListAdapter : RecyclerView.Adapter<ToDoListAdapter.MyViewHolder>() {

    private var dataList = emptyList<ToDoListPresentationModel>()

    class MyViewHolder(private val binding: RowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var title = binding.titleTxt
        var description = binding.descriptionTxt
        var priorityIndicator = binding.priorityIndicator
        var rawBackground = binding.rowBackground

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(
                    binding
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = dataList[position].title
        holder.description.text = dataList[position].description
        holder.rawBackground.setOnClickListener {
            val action = NavGraphDirections.actionGlobalToNavUpdateTodo(dataList[position])
            holder.itemView.findNavController().navigate(action)
        }

        when (dataList[position].priority) {
            "High priority" -> holder.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    ru.vdh.todo.core.ui.R.color.red
                )
            )

            "Medium priority" -> holder.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    ru.vdh.todo.core.ui.R.color.yellow
                )
            )

            "Low priority" -> holder.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    ru.vdh.todo.core.ui.R.color.green
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
}
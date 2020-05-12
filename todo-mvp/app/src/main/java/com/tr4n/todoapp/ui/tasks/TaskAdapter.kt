package com.tr4n.todoapp.ui.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tr4n.todoapp.R
import com.tr4n.todoapp.data.model.Task
import com.tr4n.todoapp.ui.base.BaseRecyclerAdapter
import com.tr4n.todoapp.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter : BaseRecyclerAdapter<Task, TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    class TaskViewHolder(itemView: View) : BaseViewHolder<Task>(itemView) {

        override fun onBindData(itemData: Task) {
            super.onBindData(itemData)

            with(itemView) {
                title.text = itemData.title
                description.text = itemData.description
            }
        }
    }
}

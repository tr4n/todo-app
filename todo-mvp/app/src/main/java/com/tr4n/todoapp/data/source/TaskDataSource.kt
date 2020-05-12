package com.tr4n.todoapp.data.source

import com.tr4n.todoapp.data.model.Task
import com.tr4n.todoapp.data.source.local.base.OnDataLoadedCallback

interface TaskDataSource {

    interface Local {
        fun getTasks(callback: OnDataLoadedCallback<List<Task>>)

        fun addTask(task: Task, callback: OnDataLoadedCallback<Boolean>)

        fun deleteTask(id: String, callback: OnDataLoadedCallback<Boolean>)

        fun updateTask(task: Task, callback: OnDataLoadedCallback<Task>)
    }

    interface Remote
}
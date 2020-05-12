package com.tr4n.todoapp.ui.tasks

import com.tr4n.todoapp.R
import com.tr4n.todoapp.data.model.Task
import com.tr4n.todoapp.data.source.TasksRepository
import com.tr4n.todoapp.data.source.local.base.OnDataLoadedCallback

class TasksPresenter(
    private val view: TasksContract.View,
    private val repository: TasksRepository
) : TasksContract.Presenter {

    override fun start() {
        getTasks()
    }

    override fun addTask(task: Task) {
        repository.addTask(task, object : OnDataLoadedCallback<Boolean> {
            override fun onSuccess(data: Boolean) {
                val msgId = if (data) R.string.msg_success else R.string.msg_error
                view.toast(msgId)
            }

            override fun onFailure(exception: Exception) {
                view.toast(exception)
            }
        })
    }

    override fun getTasks() {
        repository.getTasks(object : OnDataLoadedCallback<List<Task>> {
            override fun onSuccess(data: List<Task>) {
                view.showTasks(data)
            }

            override fun onFailure(exception: Exception) {
                view.toast(exception)
            }
        })
    }
}

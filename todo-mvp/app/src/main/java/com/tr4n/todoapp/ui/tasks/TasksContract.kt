package com.tr4n.todoapp.ui.tasks

import com.tr4n.todoapp.data.model.Task
import com.tr4n.todoapp.ui.base.BasePresenter
import com.tr4n.todoapp.ui.base.BaseView

interface TasksContract {

    interface View : BaseView {
        fun showTasks(tasks: List<Task>)
    }

    interface Presenter : BasePresenter {
        fun addTask(task: Task)

        fun getTasks()
    }
}

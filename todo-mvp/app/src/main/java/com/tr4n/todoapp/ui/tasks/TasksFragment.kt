package com.tr4n.todoapp.ui.tasks

import com.tr4n.todoapp.R
import com.tr4n.todoapp.data.model.Task
import com.tr4n.todoapp.data.source.TasksRepository
import com.tr4n.todoapp.data.source.local.TaskLocalDataSource
import com.tr4n.todoapp.data.source.local.dao.TaskDaoImpl
import com.tr4n.todoapp.data.source.remote.TaskRemoteDataSource
import com.tr4n.todoapp.ui.base.BaseFragment
import com.tr4n.todoapp.utils.showToast
import kotlinx.android.synthetic.main.fragment_tasks.*

class TasksFragment private constructor() : BaseFragment(), TasksContract.View {

    override val layoutResource get() = R.layout.fragment_tasks

    private var presenter: TasksContract.Presenter? = null

    private val taskAdapter by lazy {
        TaskAdapter()
    }

    override fun initComponents() {
        initRecyclerView()
        imageAdd.setOnClickListener {
            presenter?.addTask(Task())
        }
    }

    private fun initRecyclerView() {
        recyclerTasks.adapter = taskAdapter
    }

    override fun initData() {
        initPresenter()
        presenter?.start()
    }

    private fun initPresenter() {
        val context = context ?: return
        val localDataSource = TaskLocalDataSource.getInstance(TaskDaoImpl.getInstance(context))
        val remoteDataSource = TaskRemoteDataSource
        val repository = TasksRepository.getInstance(localDataSource, remoteDataSource)
        presenter = TasksPresenter(this, repository)
    }

    override fun showTasks(tasks: List<Task>) {
        taskAdapter.updateData(tasks)
    }

    override fun toast(obj: Any) {
        context?.showToast(obj)
    }

    companion object {
        fun newInstance() = TasksFragment()
    }
}

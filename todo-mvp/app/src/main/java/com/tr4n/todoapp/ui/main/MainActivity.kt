package com.tr4n.todoapp.ui.main

import com.tr4n.todoapp.R
import com.tr4n.todoapp.ui.base.BaseActivity
import com.tr4n.todoapp.ui.tasks.TasksFragment

class MainActivity : BaseActivity() {

    override val layoutResource get() = R.layout.activity_main

    override fun initComponent() {
        openFragment(R.id.frameMain, TasksFragment.newInstance())
    }

    override fun initData() {
    }


}

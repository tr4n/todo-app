package com.tr4n.todoapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        initComponent()
        initData()
    }

    protected abstract fun initComponent()

    protected abstract fun initData()

    protected fun openFragment(id: Int, fragment: Fragment, addToBackStack: Boolean = false) =
        supportFragmentManager.beginTransaction().replace(id, fragment).apply {
            if (addToBackStack) addToBackStack(null)
        }.commit()
}
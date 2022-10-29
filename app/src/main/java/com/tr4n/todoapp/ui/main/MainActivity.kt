package com.tr4n.todoapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tr4n.todoapp.R
import com.tr4n.todoapp.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frameMain, HomeFragment())
            .commit()
    }
}

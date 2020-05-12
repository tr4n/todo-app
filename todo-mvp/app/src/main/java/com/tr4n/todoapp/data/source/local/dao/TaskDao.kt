package com.tr4n.todoapp.data.source.local.dao

import com.tr4n.todoapp.data.model.Task

interface TaskDao {

    fun getTasks(): List<Task>

    fun addTask(task: Task): Boolean

    fun deleteTask(id: String): Boolean

    fun updateTask(task: Task)
}

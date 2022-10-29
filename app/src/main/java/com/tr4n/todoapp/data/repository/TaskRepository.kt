package com.tr4n.todoapp.data.repository

import com.tr4n.todoapp.data.Task

interface TaskRepository {

    suspend fun getTasks(): List<Task>

    suspend fun addTask(task: Task)
}

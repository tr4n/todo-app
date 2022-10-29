package com.tr4n.todoapp.data.repository

import com.tr4n.todoapp.data.Task
import com.tr4n.todoapp.data.database.AppDatabase

class TaskRepositoryImpl(
    private val database: AppDatabase
) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return database.taskDao().getTasks()
    }

    override suspend fun addTask(task: Task) {
        database.taskDao().insertTask(task)
    }
}

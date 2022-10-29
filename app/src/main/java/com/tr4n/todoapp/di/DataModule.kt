package com.tr4n.todoapp.di

import com.tr4n.todoapp.data.database.AppDatabase
import com.tr4n.todoapp.data.repository.TaskRepository
import com.tr4n.todoapp.data.repository.TaskRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        AppDatabase.getInstance(androidContext())
    }
    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
}

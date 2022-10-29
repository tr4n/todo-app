package com.tr4n.todoapp.di

import com.tr4n.todoapp.ui.add.AddViewModel
import com.tr4n.todoapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel()
    }
    viewModel {
        AddViewModel()
    }
}

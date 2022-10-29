package com.tr4n.todoapp.ui.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr4n.todoapp.data.Task
import com.tr4n.todoapp.data.repository.TaskRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AddViewModel : ViewModel(), KoinComponent {

    private val taskRepository: TaskRepository by inject()

    val isCreateSuccess = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun createTask(task: Task) = viewModelScope.launch {
        try {
            taskRepository.addTask(task)
            isCreateSuccess.value = true
        } catch (e: Exception) {
            error.value = e.message
        }
    }
}

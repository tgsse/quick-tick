package com.example.quicktick.ui.widget

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quicktick.data.Task
import com.example.quicktick.data.repository.TaskRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

data class TaskUiState(
    val tasks: List<Task> = listOf(),
)

class TaskViewModel(
    private val repository: TaskRepository,
) : ViewModel() {

    init {
        fetchTasks()
    }

    var uiState by mutableStateOf(TaskUiState())
        private set

    private var fetchJob: Job? = null

    fun fetchTasks() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val tasks = repository.fetchTasks()
                uiState = uiState.copy(tasks = tasks)
            } catch (ioe: IOException) {
                // Handle the error and notify the UI when appropriate.
//                val messages = getMessagesFromThrowable(ioe)
//                uiState = uiState.copy(userMessages = messages)
            }
        }
    }
}
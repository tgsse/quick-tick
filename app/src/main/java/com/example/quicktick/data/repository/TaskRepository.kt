package com.example.quicktick.data.repository

import com.example.quicktick.data.Task
import com.example.quicktick.data.TaskRemoteDataSource

class TaskRepository(
    private val taskRemoteDataSource: TaskRemoteDataSource, // network
//    private val localTaskDataSource: TaskLocalDataSource // database
) {
    companion object {
        val dummyTasks = listOf(
            Task(id = "1", title = "Task 1"),
            Task(id = "2", title = "Task 2"),
            Task(id = "3", title = "Task 3"),
            Task(id = "4", title = "Task 4"),
            Task(id = "5", title = "Task 5"),
            Task(id = "6", title = "Task 6"),
            Task(id = "7", title = "Task 7"),
            Task(id = "8", title = "Task 8"),
        )
    }

    //    suspend fun fetchTasks(): List<Task> = taskRemoteDataSource.fetchTasks()
    suspend fun fetchTasks(): List<Task> = dummyTasks
}
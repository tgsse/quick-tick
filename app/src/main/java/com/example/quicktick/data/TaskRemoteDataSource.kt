package com.example.quicktick.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class TaskRemoteDataSource(
    private val taskApi: TaskApi,
    private val ioDispatcher: CoroutineDispatcher
) {
    /**
     * Fetches the latest tasks from the network and returns the result.
     * This executes on an IO-optimized thread pool, the function is main-safe.
     */
    suspend fun fetchTasks(): List<Task> =
    // Move the execution to an IO-optimized thread since the ApiService
        // doesn't support coroutines and makes synchronous requests.
        withContext(ioDispatcher) {
            taskApi.fetchLatestTasks()
        }
}

// Makes task-related network synchronous requests.
interface TaskApi {
    fun fetchLatestTasks(): List<Task>
}

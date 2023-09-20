package com.example.quicktick.ui.widget.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.Text
import com.example.quicktick.data.repository.TaskRepository.Companion.dummyTasks

@Composable
fun ActiveTaskRow(activeTaskId: String?) {
    if (activeTaskId === null) {
        Text(text = "No active tasks at the moment")
        return
    }

    val task = dummyTasks.find { it.id == activeTaskId }
//    val task = Task("11", "test")
    Log.d("ActiveTaskRow", "task: $task")
    Row(
        modifier = GlanceModifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.DarkGray.copy(alpha = 1f)),
    ) {
        if (task !== null) {
            TaskButton(
                task = task,
                onClick = {
                    Log.d(this.javaClass.toString(), "Clicked task In Progress")
                },
            )
        } else {
            Text(text = "No active tasks at the moment")
        }
    }
}
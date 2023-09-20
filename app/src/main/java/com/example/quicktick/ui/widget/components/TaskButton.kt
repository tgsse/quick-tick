package com.example.quicktick.ui.widget.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.cornerRadius
import androidx.glance.layout.fillMaxWidth
import com.example.quicktick.data.Task

@Composable
fun TaskButton(
    task: Task,
    onClick: () -> Unit,
) {
    Button(
        text = task.title,
        onClick = { onClick() },
        modifier = GlanceModifier
            .cornerRadius(2.dp)
            .fillMaxWidth()
    )

}
package com.example.quicktick.ui.widget

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.Text
import com.example.quicktick.data.repository.TaskRepository.Companion.dummyTasks
import com.example.quicktick.ui.widget.WidgetUtil.Companion.activeTaskPrefKey
import com.example.quicktick.ui.widget.components.ActiveTaskRow
import com.example.quicktick.ui.widget.components.TaskList

class GlanceWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Content()
        }
    }

    @Composable
    private fun Content() {
        Widget()
    }
}

@Composable
fun Widget(
//    viewModel: TaskViewModel = viewModel(),
) {
    val activeTaskId = currentState(key = activeTaskPrefKey)

    Log.d("Widget activeTaskKey", "$activeTaskPrefKey: (id: $activeTaskId)")

    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(Color.DarkGray.copy(alpha = .5f)),
        verticalAlignment = Alignment.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Hi! $activeTaskId",
        )
        ActiveTaskRow(activeTaskId = activeTaskId)
        TaskList(tasks = dummyTasks)
    }
}

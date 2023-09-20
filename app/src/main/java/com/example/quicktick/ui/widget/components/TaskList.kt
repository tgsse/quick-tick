package com.example.quicktick.ui.widget.components

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionParametersOf
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import com.example.quicktick.data.Task
import com.example.quicktick.ui.widget.GlanceWidget
import com.example.quicktick.ui.widget.WidgetUtil.Companion.activeTaskPrefKey
import com.example.quicktick.ui.widget.WidgetUtil.Companion.taskIdActionParamKey

@Composable
fun TaskList(
    tasks: List<Task>,
) {

    fun onTaskClick(id: String) = actionRunCallback(
        callbackClass = StartTaskActionCallback::class.java,
        parameters = actionParametersOf(taskIdActionParamKey to id))


    Column(
        modifier = GlanceModifier
            .background(Color.DarkGray.copy(alpha = .75f)),
    ) {
        LazyColumn(
            modifier = GlanceModifier
        ) {
            items(tasks) {task ->
                Row(
                    modifier = GlanceModifier
                        .padding(bottom = 8.dp)
                ) {
                    Button(
                        text = task.title,
                        onClick = onTaskClick(id = task.id),
                        modifier = GlanceModifier
                            .cornerRadius(1.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

class StartTaskActionCallback : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        Log.d("StartTaskActionCallback", "callback...")
        val newId = parameters[taskIdActionParamKey] ?: return
        Log.d("StartTaskActionCallback", "setting new task to active $newId")
        updateAppWidgetState(context, glanceId) { prefs ->
            prefs[activeTaskPrefKey] = newId
        }
        GlanceWidget().update(context, glanceId)
    }
}

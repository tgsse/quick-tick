package com.example.quicktick.ui.widget

import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.action.ActionParameters

class WidgetUtil {
    companion object {
        // Action param keys
        val taskIdActionParamKey = ActionParameters.Key<String>("id")

        // Pref keys
        val activeTaskPrefKey = stringPreferencesKey(name = "ACTIVE_TASK_KEY")
    }
}
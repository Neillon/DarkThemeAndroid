package com.neillon.darkthemeapp

import android.content.Context
import androidx.preference.PreferenceManager

class ThemePreferences(context: Context) {
    companion object {
        const val DEFAULT_THEME = "com.neillon.darkthemeapp.theme"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    var theme = preferences.getInt(DEFAULT_THEME, 0)
        set(value) = preferences.edit().putInt(DEFAULT_THEME, value).apply()
}
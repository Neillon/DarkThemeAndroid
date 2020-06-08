package com.neillon.darkthemeapp

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkTheme()
        supportActionBar?.title = resources.getString(R.string.app_theme)
        mButtonChangeTheme.setOnClickListener { openChooseThemeDialog() }
    }

    private fun openChooseThemeDialog() {
        val themes = arrayOf("Light", "Dark", "System default")
        val defaultTheme = ThemePreferences(this).theme
        AlertDialog
                .Builder(this)
                .setTitle("Choose a theme")
                .setSingleChoiceItems(themes, defaultTheme, ::chooseTheme)
                .create()
                .show()
    }

    private fun chooseTheme(dialog: DialogInterface, which: Int) {
        when(which) {
            // Dark mode
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
                ThemePreferences(this).theme = 0
                dialog.dismiss()
            }
            // Light mode
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
                ThemePreferences(this).theme = 1
                dialog.dismiss()
            }
            // System default
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
                ThemePreferences(this).theme = 2
                dialog.dismiss()
            }

        }
    }

    private fun checkTheme() {
        when (ThemePreferences(this).theme) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
            }
        }
    }
}
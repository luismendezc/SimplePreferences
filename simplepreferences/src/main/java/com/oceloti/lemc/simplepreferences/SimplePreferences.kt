package com.oceloti.lemc.simplepreferences

import android.content.Context


object SimplePreferences : PreferencesManager {
  private var manager: PreferencesManager? = null

  fun initialize(context: Context) {
    if (manager == null) {
      manager = PreferencesManagerImpl(context)
    }
  }

  override fun putString(key: String, value: String) {
    manager?.putString(key, value)
      ?: throw IllegalStateException("SimplePreferences is not initialized. Call initialize() first.")
  }

  override fun getString(key: String, defaultValue: String): String {
    return manager?.getString(key, defaultValue)
      ?: throw IllegalStateException("SimplePreferences is not initialized. Call initialize() first.")
  }
}
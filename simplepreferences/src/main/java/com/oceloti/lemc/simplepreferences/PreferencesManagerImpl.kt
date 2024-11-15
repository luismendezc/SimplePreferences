package com.oceloti.lemc.simplepreferences

import android.content.Context
import android.content.SharedPreferences


internal class PreferencesManagerImpl(context: Context) : PreferencesManager {
  private val sharedPreferences: SharedPreferences =
    context.getSharedPreferences("SimplePreferences", Context.MODE_PRIVATE)

  override fun putString(key: String, value: String) {
    sharedPreferences.edit().putString(key, value).apply()
  }

  override fun getString(key: String, defaultValue: String): String {
    return sharedPreferences.getString(key, defaultValue) ?: defaultValue
  }
}
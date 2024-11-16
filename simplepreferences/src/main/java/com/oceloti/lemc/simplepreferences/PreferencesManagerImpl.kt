package com.oceloti.lemc.simplepreferences

import android.content.Context
import android.content.SharedPreferences

/**
 * Internal implementation of [PreferencesManager] using [SharedPreferences].
 *
 * This class is used internally by [SimplePreferences] to perform actual storage and retrieval of string values.
 *
 * @param context The context used to access shared preferences.
 */
internal class PreferencesManagerImpl(context: Context) : PreferencesManager {
  private val sharedPreferences: SharedPreferences =
    context.getSharedPreferences("SimplePreferences", Context.MODE_PRIVATE)

  /**
   * Stores a string value in shared preferences.
   *
   * @param key The key with which the value will be associated.
   * @param value The string value to be stored.
   */
  override fun putString(key: String, value: String) {
    sharedPreferences.edit().putString(key, value).apply()
  }

  /**
   * Retrieves a string value from shared preferences.
   *
   * @param key The key whose associated value is to be returned.
   * @param defaultValue The value to return if no value is found for the given key.
   * @return The string value associated with the key, or [defaultValue] if no value is found.
   */
  override fun getString(key: String, defaultValue: String): String {
    return sharedPreferences.getString(key, defaultValue) ?: defaultValue
  }
}

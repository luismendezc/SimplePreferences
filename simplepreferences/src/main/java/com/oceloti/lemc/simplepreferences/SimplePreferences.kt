package com.oceloti.lemc.simplepreferences

import android.content.Context

/**
 * Singleton object for managing string preferences using [PreferencesManager].
 *
 * Provides a simplified API for storing and retrieving string preferences. This object must be
 * initialized with a [Context] before any operations can be performed.
 */
object SimplePreferences : PreferencesManager {
  private var manager: PreferencesManager? = null

  /**
   * Initializes the [SimplePreferences] object with a [Context].
   *
   * This method must be called before any other methods are used.
   *
   * @param context The context used to initialize the internal [PreferencesManager] instance.
   */
  fun initialize(context: Context) {
    if (manager == null) {
      manager = PreferencesManagerImpl(context)
    }
  }

  /**
   * Stores a string value in shared preferences.
   *
   * @param key The key with which the value will be associated.
   * @param value The string value to be stored.
   * @throws IllegalStateException if [initialize] was not called before using this method.
   */
  override fun putString(key: String, value: String) {
    manager?.putString(key, value)
      ?: throw IllegalStateException("SimplePreferences is not initialized. Call initialize() first.")
  }

  /**
   * Retrieves a string value from shared preferences.
   *
   * @param key The key whose associated value is to be returned.
   * @param defaultValue The value to return if no value is found for the given key.
   * @return The string value associated with the key, or [defaultValue] if no value is found.
   * @throws IllegalStateException if [initialize] was not called before using this method.
   */
  override fun getString(key: String, defaultValue: String): String {
    return manager?.getString(key, defaultValue)
      ?: throw IllegalStateException("SimplePreferences is not initialized. Call initialize() first.")
  }
}

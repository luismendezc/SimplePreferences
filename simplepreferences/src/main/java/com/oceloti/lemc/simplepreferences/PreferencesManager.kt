package com.oceloti.lemc.simplepreferences

/**
 * Interface for managing string key-value pairs in shared preferences.
 */
interface PreferencesManager {

  /**
   * Stores a string value in shared preferences.
   *
   * @param key The key with which the value will be associated.
   * @param value The string value to be stored.
   */
  fun putString(key: String, value: String)

  /**
   * Retrieves a string value from shared preferences.
   *
   * @param key The key whose associated value is to be returned.
   * @param defaultValue The value to return if no value is found for the given key.
   * @return The string value associated with the key, or [defaultValue] if no value is found.
   */
  fun getString(key: String, defaultValue: String = ""): String
}

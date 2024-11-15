package com.oceloti.lemc.simplepreferences

interface PreferencesManager {
  fun putString(key: String, value: String)
  fun getString(key: String, defaultValue: String = ""): String
}
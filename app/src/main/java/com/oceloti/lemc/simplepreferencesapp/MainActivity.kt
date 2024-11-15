package com.oceloti.lemc.simplepreferencesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oceloti.lemc.simplepreferences.SimplePreferences
import com.oceloti.lemc.simplepreferencesapp.ui.theme.SimplePreferencesAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()


    SimplePreferences.initialize(this)

    setContent {
      SimplePreferencesAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          MainScreen(
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
  val key = "example_key"
  val storedValue = remember { mutableStateOf(SimplePreferences.getString(key, "Default Value")) }

  Column(modifier = Modifier.padding(16.dp)) {
    Text(text = "Stored Value: ${storedValue.value}")

    Button(onClick = {
      SimplePreferences.putString(key, "Hello, Compose!")
      storedValue.value = SimplePreferences.getString(key)
    }) {
      Text(text = "Store Value")
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  SimplePreferencesAppTheme {
    Greeting("Android")
  }
}
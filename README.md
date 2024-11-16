# SimplePreferences
A lightweight, easy-to-use Android library for managing SharedPreferences with a simple and clean API. It provides utility functions to save, retrieve, and observe changes to shared preferences, making it useful for handling app settings, user preferences, and small data storage needs.

[![](https://jitpack.io/v/luismendezc/SimplePreferences.svg)](https://jitpack.io/#luismendezc/SimplePreferences)

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [API Documentation](#api-documentation)
- [License](#license)

## Installation

Add the following to your `build.gradle` (app module) file:
```gradle
dependencies {
    implementation 'com.github.luismendezc:SimplePreferences:0.0.2' // Update to the latest version
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

## Usage

To start using `SimplePreferences`, initialize it in your `Application` class or `Activity`:

```kotlin
// Initialize SimplePreferences
SimplePreferences.initialize(context)

// Save a value
SimplePreferences.putString("user_name", "John Doe")

// Retrieve a value
val userName = SimplePreferences.getString("user_name", "Default User")
println("User Name: $userName")
```

## Features
- Easy initialization and usage
- Lightweight and fast
- Utility functions for saving and retrieving string values from SharedPreferences
- Supports a singleton pattern for global access

## API Documentation

The API documentation is generated using Dokka and can be found in the `build/dokka/html` directory after building the project. To generate the documentation, run:

```bash
./gradlew dokkaHtml
```

### Public API
- `initialize(context: Context)`
  Initializes the library.
- `putString(key: String, value: String)`
  Stores a string value.
- `getString(key: String, defaultValue: String): String`
  Retrieves a string value with a default fallback.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request for any improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


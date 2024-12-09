# Weather Project

WeatherApp is a mobile application that allows users to check the weather in different cities. It provides detailed information such as weather description, humidity, country, and more through a modern and fluid interface designed with Jetpack Compose.

## Prerequisites
- Register for an API Key at OpenWeatherMap.
 Configure it in the `DataConstants` file as follows

`const val WEATHER_API_KEY = "YOUR_API_KEY"`

path: `/weather-project/data/src/main/java/com/example/data/util/DataConstants.kt`

## Technologies Used

#### - Jetpack Compose
Modern, declarative, and highly customizable UI implementation.

#### - Kotlin Coroutines
Handles asynchronous operations for API calls and UI state updates.

#### - Flow
Reactive state management and observation using StateFlow, enabling efficient and consistent updates.

#### - Retrofit + Moshi
Retrofit: HTTP client to consume the OpenWeatherMap API.
Moshi: Parses JSON responses into data models.

#### - Dagger Hilt
Dependency injection for easy management and configuration of components like repositories, ViewModels, and network services.

#### - OkHttp
Efficient HTTP request handling with support for request and response logging.

#### - Lottie
Attractive animations to improve user experience.

## Architecture

#### - Domain:
Contains business rules and use cases.
Independent of frameworks and platforms.

#### - Data:
Manages interaction with external data sources.
Includes repositories and HTTP services configured with Retrofit and Moshi.

#### - Presentation:
Responsible for the UI and presentation logic.
Uses StateFlow and ViewModel for reactive state management.
Fully built with Jetpack Compose.


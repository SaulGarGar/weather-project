package com.example.domain.model

data class WeatherByCity(
    val cityName: String,
    val temperature: Double,
    val description: String,
    val humidity: Int,
    val country: String,
    val weatherMain: String,
    val coordinates: Coordinates
)

data class Coordinates(
    val longitude: Double,
    val latitude: Double
)
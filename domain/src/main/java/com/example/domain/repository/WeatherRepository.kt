package com.example.domain.repository

interface WeatherRepository {
    suspend fun getWeatherByCity(city: String) //TODO: Create weather response
}
package com.example.domain.repository

interface WeatherRepository {
    suspend fun getWeather() //TODO: Create weather response
}
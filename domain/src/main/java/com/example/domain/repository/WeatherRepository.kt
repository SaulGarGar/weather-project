package com.example.domain.repository

import com.example.domain.model.Result
import com.example.domain.model.WeatherByCity

interface WeatherRepository {

    suspend fun getWeatherByCity(city: String): Result<WeatherByCity>
}
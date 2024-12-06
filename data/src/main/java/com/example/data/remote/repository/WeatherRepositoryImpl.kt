package com.example.data.remote.repository

import com.example.data.remote.api.ApiWeatherService
import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiWeatherService: ApiWeatherService
): WeatherRepository {
    override suspend fun getWeather() {
        TODO("Not yet implemented")
    }
}
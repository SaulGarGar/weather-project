package com.example.data.remote.repository

import com.example.data.model.toDomain
import com.example.data.remote.api.ApiWeatherService
import com.example.data.util.safeApiCall
import com.example.domain.model.Result
import com.example.domain.model.WeatherByCity
import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiWeatherService: ApiWeatherService
) : WeatherRepository {
    override suspend fun getWeatherByCity(city: String): Result<WeatherByCity> {
        return safeApiCall {
            val weather = apiWeatherService.getWeatherByCity(city)
            weather.toDomain()
        }
    }
}
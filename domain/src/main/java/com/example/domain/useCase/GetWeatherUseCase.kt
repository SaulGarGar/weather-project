package com.example.domain.useCase

import com.example.domain.model.Result
import com.example.domain.model.WeatherByCity
import com.example.domain.repository.WeatherRepository

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(city: String): Result<WeatherByCity> =
        weatherRepository.getWeatherByCity(city)
}
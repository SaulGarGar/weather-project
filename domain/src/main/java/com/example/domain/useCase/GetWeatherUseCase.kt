package com.example.domain.useCase

import com.example.domain.model.Result
import com.example.domain.model.WeatherByCity
import com.example.domain.repository.WeatherRepository
import com.example.domain.util.flowFromResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(city: String): Flow<Result<WeatherByCity>> {
        return flowFromResult { weatherRepository.getWeatherByCity(city) }
    }
}
package com.example.domain.useCase

import com.example.domain.repository.WeatherRepository

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(){
        //TODO: return repository data
    }
}
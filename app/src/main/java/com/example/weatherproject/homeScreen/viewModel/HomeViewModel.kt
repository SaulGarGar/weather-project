package com.example.weatherproject.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import com.example.domain.useCase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    getWeatherUseCase: GetWeatherUseCase
): ViewModel(){
    fun getWeather() {

    }
}
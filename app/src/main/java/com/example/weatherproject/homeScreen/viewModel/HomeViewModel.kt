package com.example.weatherproject.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Result
import com.example.domain.model.WeatherByCity
import com.example.domain.useCase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel(){

    private val _cityWeather = MutableStateFlow<Result<WeatherByCity>?>(null)
    val cityWeather: StateFlow<Result<WeatherByCity>?> = _cityWeather

    fun getWeatherByCity(city: String) {
        viewModelScope.launch {
            getWeatherUseCase.invoke(city)
                .catch { exception ->
                    _cityWeather.value = Result.Error(exception as Exception)
                }
                .collect { result ->
                    _cityWeather.value = result
                }
        }
    }
}
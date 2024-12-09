package com.example.weatherproject.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Result
import com.example.domain.model.WeatherByCity
import com.example.domain.useCase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherUiState>(WeatherUiState.Idle)
    val weatherState: StateFlow<WeatherUiState> = _weatherState

    fun getWeatherByCity(city: String) {
        _weatherState.value = WeatherUiState.Loading
        viewModelScope.launch {
            getWeatherUseCase.invoke(city).collect { result ->
                when (result) {
                    is Result.Success -> {
                        _weatherState.value = WeatherUiState.Success(result.data)
                    }

                    is Result.Error -> {
                        _weatherState.value =
                            WeatherUiState.Error(result.exception.message ?: "Unknown error")
                    }
                }
            }

        }
    }
}

sealed class WeatherUiState {
    object Idle : WeatherUiState()
    object Loading : WeatherUiState()
    data class Success(val data: WeatherByCity) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}
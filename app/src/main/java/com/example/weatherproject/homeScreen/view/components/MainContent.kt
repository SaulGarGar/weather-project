package com.example.weatherproject.homeScreen.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherproject.homeScreen.viewModel.WeatherUiState
import com.example.weatherproject.util.*
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    weatherState: StateFlow<WeatherUiState>,
    onCitySelected: (String) -> Unit
) {
    val state by weatherState.collectAsState()

    val cities = listOf(
        HOME_DEFAULT_CITY,
        MEXICO_CITY_LIST_NAME,
        TORONTO_LIST_NAME,
        VANCOUVER_LIST_NAME,
        SAN_FRANCISCO_LIST_NAME,
        PARIS_LIST_NAME,
        MERIDA_LIST_NAME,
        ROMA_LIST_NAME,
        MEDELLIN_CITY_LIST_NAME,
        RIO_DE_JANEIRO_LIST_NAME,
        ALASKA_LIST_NAME
        )

    var selectedCity by remember { mutableStateOf(cities.first()) }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = SELECT_A_CITY_LABEL,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))

        CityDropdownMenu(
            cities = cities,
            selectedCity = selectedCity,
            onCitySelected = { city ->
                selectedCity = city
                onCitySelected(city)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        when (state) {
            is WeatherUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator(
                        color = Color.White
                    )
                }
            }

            is WeatherUiState.Success -> {
                val weather = (state as WeatherUiState.Success).data
                WeatherDetails(weather = weather)
            }

            is WeatherUiState.Error -> {
                Text(
                    text = (state as WeatherUiState.Error).message,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            else -> {
                Text(
                    text = "Select a city to get the weather.",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
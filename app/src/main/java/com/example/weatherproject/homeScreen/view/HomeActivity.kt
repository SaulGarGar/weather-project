package com.example.weatherproject.homeScreen.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.weatherproject.homeScreen.view.components.MainContent
import com.example.weatherproject.homeScreen.viewModel.HomeViewModel
import com.example.weatherproject.ui.theme.LightBlue
import com.example.weatherproject.ui.theme.WeatherProjectTheme
import com.example.weatherproject.util.HOME_DEFAULT_CITY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherProjectTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = LightBlue
                ) { innerPadding ->
                    MainContent(
                        modifier = Modifier.padding(innerPadding),
                        weatherState = viewModel.weatherState,
                        onCitySelected = { city ->
                            viewModel.getWeatherByCity(city)
                        }
                    )
                }
            }
        }
        viewModel.getWeatherByCity(HOME_DEFAULT_CITY)
    }
}
package com.example.weatherproject.homeScreen.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.weatherproject.R
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
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error_animation))

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
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        LottieAnimation(
                            composition = composition,
                            modifier = Modifier
                                .size(300.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(bottom = 24.dp),
                            iterations = LottieConstants.IterateForever
                        )
                        Text(
                            text = (state as WeatherUiState.Error).message,
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
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
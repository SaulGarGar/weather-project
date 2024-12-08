package com.example.weatherproject.homeScreen.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.model.WeatherByCity

@Composable
fun WeatherDetails(weather: WeatherByCity) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "City: ${weather.cityName}")
        Text(text = "Temperature: ${weather.temperature}°C")
        Text(text = "Description: ${weather.description}")
        Text(text = "Humidity: ${weather.humidity}%")
        Text(text = "Wind Speed: ${weather.windSpeed} m/s")
        Text(text = "Country: ${weather.country}")
        Text(text = "Weather: ${weather.weatherMain}")
        Text(text = "Sunrise: ${formatTime(weather.sunrise)}")
        Text(text = "Sunset: ${formatTime(weather.sunset)}")
    }
}

fun formatTime(timestamp: Long): String {
    val date = java.util.Date(timestamp * 1000)
    val sdf = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault())
    sdf.timeZone = java.util.TimeZone.getDefault()
    return sdf.format(date)
}
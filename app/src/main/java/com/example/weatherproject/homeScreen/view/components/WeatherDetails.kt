package com.example.weatherproject.homeScreen.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.domain.model.WeatherByCity
import com.example.weatherproject.R
import com.example.weatherproject.util.COUNTRY_LABEL
import com.example.weatherproject.util.DESCRIPTION_LABEL
import com.example.weatherproject.util.HUMIDITY_LABEL
import com.example.weatherproject.util.PERCENT_SIGN
import com.example.weatherproject.util.TEMPERATURE_UNIT
import com.example.weatherproject.util.WEATHER_LABEL

@Composable
fun WeatherDetails(weather: WeatherByCity) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.weather_animation))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = weather.cityName,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${weather.temperature}$TEMPERATURE_UNIT",
            fontSize = 64.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(300.dp),
            iterations = LottieConstants.IterateForever
        )
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = buildBoldText(DESCRIPTION_LABEL, weather.description),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = buildBoldText(HUMIDITY_LABEL, "${weather.humidity}$PERCENT_SIGN"),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = buildBoldText(COUNTRY_LABEL, weather.country),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = buildBoldText(WEATHER_LABEL, weather.weatherMain),
            color = Color.White
        )
    }
}

private fun buildBoldText(label: String, value: String): AnnotatedString {
    return buildAnnotatedString {
        append(label)
        addStyle(
            style = SpanStyle(fontWeight = FontWeight.Bold),
            start = 0,
            end = label.length
        )
        append(": $value")
    }
}
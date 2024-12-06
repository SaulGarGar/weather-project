package com.example.data.remote.api

import com.example.data.model.WeatherByCityResponse
import com.example.data.util.CITY_PARAMETER_ID
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeatherService {
    @GET
    fun getWeatherByCity(@Query(CITY_PARAMETER_ID) city: String): WeatherByCityResponse
}
package com.example.data.remote.api

import com.example.data.util.CITY_PARAMETER_ID
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeatherService {
    @GET
    fun getWeatherByCity(@Query(CITY_PARAMETER_ID) city: String): Response
}
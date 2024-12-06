package com.example.data.di

import com.example.data.remote.WEATHER_API_KEY
import com.example.data.remote.WEATHER_API_KEY_PARAMETER_ID
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()

        val urlWithApiKey = originalUrl.newBuilder()
            .addQueryParameter(WEATHER_API_KEY_PARAMETER_ID, WEATHER_API_KEY)
            .build()

        val requestWithApiKey = originalRequest.newBuilder()
            .url(urlWithApiKey)
            .build()

        return chain.proceed(requestWithApiKey)
    }
}
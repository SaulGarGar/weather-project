package com.example.data.di

import com.example.data.remote.api.ApiWeatherService
import com.example.data.remote.repository.WeatherRepositoryImpl
import com.example.domain.repository.WeatherRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(retrofit: Retrofit): ApiWeatherService {
        return retrofit.create(ApiWeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(apiWeatherService: ApiWeatherService): WeatherRepository {
        return WeatherRepositoryImpl(apiWeatherService)
    }
}
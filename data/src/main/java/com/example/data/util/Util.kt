package com.example.data.util

import com.example.domain.model.Result

import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        Result.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        val exception = when (throwable) {
            is IOException -> NetworkException(NETWORK_EXCEPTION_ERROR, throwable)
            is HttpException -> ApiException(API_EXCEPTION_ERROR, throwable)
            else -> UnknownException(UNKNOWN_EXCEPTION_ERROR, throwable)
        }
        Result.Error(exception)
    }
}
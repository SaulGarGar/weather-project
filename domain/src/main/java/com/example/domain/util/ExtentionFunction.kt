package com.example.domain.util

import com.example.domain.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> flowFromResult(apiCall: suspend () -> Result<T>): Flow<Result<T>> {
    return flow {
        emit(apiCall())
    }
}
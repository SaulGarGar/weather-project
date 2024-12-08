package com.example.data.util

open class AppException(message: String, cause: Throwable? = null) : Exception(message, cause)

class NetworkException(message: String, cause: Throwable? = null) : AppException(message, cause)
class ApiException(message: String, cause: Throwable? = null) : AppException(message, cause)
class ApiAuthorizationException(message: String, cause: Throwable? = null) : AppException(message, cause)
class UnknownException(message: String, cause: Throwable? = null) : AppException(message, cause)
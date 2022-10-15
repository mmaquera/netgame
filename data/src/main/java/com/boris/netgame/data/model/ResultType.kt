package com.boris.netgame.data.model

sealed class ResultType<T> {
    class Success<T>(val data: T) : ResultType<T>()
    class Error<T>(val error: String) : ResultType<T>()
    class AnotherError<T>(val e: Exception) : ResultType<T>()
}
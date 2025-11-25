package com.raquetel.app.core.util

sealed class Result<out T> {
    
    data class Success<T>(val data: T) : Result<T>()
    
    data class Error(
        val message: String,
        val throwable: Throwable? = null
    ) : Result<Nothing>()
    
    object Loading : Result<Nothing>()
    
    inline fun <R> map(transform: (T) -> R): Result<R> {
        return when (this) {
            is Success -> Success(transform(data))
            is Error -> Error(message, throwable)
            is Loading -> Loading
        }
    }
    
    inline fun onSuccess(action: (T) -> Unit): Result<T> {
        if (this is Success) {
            action(data)
        }
        return this
    }
    
    inline fun onError(action: (String, Throwable?) -> Unit): Result<T> {
        if (this is Error) {
            action(message, throwable)
        }
        return this
    }
    
    fun getOrNull(): T? {
        return when (this) {
            is Success -> data
            else -> null
        }
    }
    
    fun getOrElse(defaultValue: @UnsafeVariance T): T {
        return when (this) {
            is Success -> data
            else -> defaultValue
        }
    }
}

inline fun <T> runCatching(block: () -> T): Result<T> {
    return try {
        Result.Success(block())
    } catch (e: Exception) {
        Result.Error(e.message ?: "Unknown error", e)
    }
}

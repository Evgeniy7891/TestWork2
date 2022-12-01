package com.example.testwork2.error

import java.io.IOException

sealed class AppError(var code: String) : RuntimeException() {
    companion object {
        fun from(e: Throwable) : AppError = when (e) {
            is AppError -> e
            is IOException -> NetworkError
            else -> UnknowError
        }
    }
}

class ApiError(val status: Int, code: String) : AppError(code)
object NetworkError : AppError("error_network")
object UnknowError : AppError("error_unknow")

package com.example.foodshop.data.network.models

sealed class ResponseWrapper<out T> {

    data class Success<out T>(val value: T) : ResponseWrapper<T>()

    object NetworkError : ResponseWrapper<Nothing>()

    data class GenericError(val code: Int? = null) : ResponseWrapper<Nothing>()
}

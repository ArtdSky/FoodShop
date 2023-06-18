package com.example.foodshop.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Синглтон сервис конфгурирующий ретрофит
 */
object NetworkService {
    private const val BASE_URL =
        "https://run.mocky.io/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    /**
     * Возвращает экземпляр ретрофит реализующий интерфейс [NetworkEndpoint]
     */
    val retrofitService by lazy {
        retrofit.create(NetworkEndpoint::class.java)
    }
}
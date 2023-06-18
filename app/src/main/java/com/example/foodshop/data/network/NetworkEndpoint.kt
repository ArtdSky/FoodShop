package com.example.foodshop.data.network

import com.example.foodshop.data.network.models.ResponseFoodData
import retrofit2.http.GET

/**
 * Интерфейс для точек доступа получения данных о еде
 */
interface NetworkEndpoint {

    /**
     * Получает все данные о еде с
     *
     * @return Объект [ResponseFoodData], содержащий данные о еде.
     */
    @GET("/v3/18c6724c-b77b-45cd-ba10-7ed189d98a53")
    suspend fun getAllFoodData(): ResponseFoodData
}
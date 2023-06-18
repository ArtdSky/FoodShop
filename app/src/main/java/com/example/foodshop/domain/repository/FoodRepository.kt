package com.example.foodshop.domain.repository

import com.example.foodshop.domain.models.FoodData

/**
 * Интерфейс для получения данных о еде.
 */
interface FoodRepository {

    /**
     * Метод для получения данных о еде.
     *
     * @return [FoodData] - объект данных о еде или null, если произошла ошибка или  если данных нет
     */
    suspend fun getFoodData() : FoodData?
}
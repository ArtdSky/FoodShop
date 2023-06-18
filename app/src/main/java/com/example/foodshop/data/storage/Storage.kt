package com.example.foodshop.data.storage

import com.example.foodshop.data.network.models.ResponseFoodData
import com.example.foodshop.data.network.models.ResponseWrapper
import kotlinx.coroutines.flow.Flow

/**
 * Интерфейс определяет методы для доступа к хранилищу данных приложения
 */
interface Storage {

    /**
     * Получает все данные о еде из хранилища.
     * @return [Flow] с оберткой [ResponseWrapper] результата сетевого вызова.
     * Результат содержит [ResponseFoodData] или информацию об ошибке.
     */
    suspend fun getAllFoodData(): Flow<ResponseWrapper<ResponseFoodData>>
}
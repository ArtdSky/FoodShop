package com.example.foodshop.domain.usecases

import com.example.foodshop.domain.models.FoodData
import com.example.foodshop.domain.repository.FoodRepository

/**
 * Класс  usecase для получения всех данных о еде.
 *
 * @property foodRepository репозиторий из которого извлекаются данные.
 */
class GetAllFoodData(
    private val foodRepository: FoodRepository
) {
    suspend operator fun invoke(): FoodData? {
        return foodRepository.getFoodData()
    }
}
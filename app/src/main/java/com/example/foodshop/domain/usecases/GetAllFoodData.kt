package com.example.foodshop.domain.usecases

import com.example.foodshop.domain.models.FoodData
import com.example.foodshop.domain.repository.FoodRepository

class GetAllFoodData(
    private val foodRepository: FoodRepository
) {
    suspend operator fun invoke(): FoodData? {
        return foodRepository.getFoodData()
    }
}
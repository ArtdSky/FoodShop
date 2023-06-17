package com.example.foodshop.domain.repository

import com.example.foodshop.domain.models.FoodData

interface FoodRepository {

    suspend fun getFoodData() : FoodData?
}
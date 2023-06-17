package com.example.foodshop.data.repository

import android.util.Log
import com.example.foodshop.data.network.models.ResponseWrapper
import com.example.foodshop.data.storage.Storage
import com.example.foodshop.domain.models.FoodData
import com.example.foodshop.domain.repository.FoodRepository
import kotlinx.coroutines.flow.single

class RepositoryImpl(
    private val storage: Storage
) : FoodRepository {

    override suspend fun getFoodData(): FoodData? {
        return when (val foodData = storage.getAllFoodData().single()) {
            is ResponseWrapper.Success -> {
                mapMenuDataToDomain(foodData.value.menu)
            }
            is ResponseWrapper.NetworkError -> {
                Log.d("NO NETWORK", "NO NETWORK FOR LOAD FoodData")
                null
            }
            is ResponseWrapper.GenericError -> {
                Log.d("GENERIC DATA", "${foodData.code}")
                null
            }
        }

    }
}
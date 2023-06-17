package com.example.foodshop.data.storage

import com.example.foodshop.data.network.models.ResponseFoodData
import com.example.foodshop.data.network.models.ResponseWrapper
import kotlinx.coroutines.flow.Flow

interface Storage {


    suspend fun getAllFoodData() : Flow<ResponseWrapper<ResponseFoodData>>
}
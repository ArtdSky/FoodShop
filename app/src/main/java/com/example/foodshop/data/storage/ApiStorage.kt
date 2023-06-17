package com.example.foodshop.data.storage

import com.example.foodshop.data.network.NetworkService
import com.example.foodshop.data.network.models.ResponseFoodData
import com.example.foodshop.data.network.models.ResponseWrapper
import com.example.foodshop.data.network.safeNetworkCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiStorage : Storage {
    override suspend fun getAllFoodData(): Flow<ResponseWrapper<ResponseFoodData>> {
        val res : Flow<ResponseWrapper<ResponseFoodData>> = flow{
            val response = safeNetworkCall(Dispatchers.IO){
                NetworkService.retrofitService.getAllFoodData()
            }
            emit(response)
        }
        return res
    }
}
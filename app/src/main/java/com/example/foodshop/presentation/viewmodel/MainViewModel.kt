package com.example.foodshop.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodshop.domain.usecases.GetAllFoodData
import kotlinx.coroutines.launch

class MainViewModel(
 private val getAllFoodData: GetAllFoodData
) : ViewModel(){

    init{
        viewModelScope.launch {
            Log.d("VM", getAllFoodData().toString())
        }
    }
}
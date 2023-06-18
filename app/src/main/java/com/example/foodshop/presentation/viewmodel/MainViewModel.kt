package com.example.foodshop.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodshop.domain.usecases.GetAllFoodData
import com.example.foodshop.presentation.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
 private val getAllFoodData: GetAllFoodData
) : ViewModel(){


    private val _viewState = MutableStateFlow(
        ViewState()
    )
    val viewState = _viewState.asStateFlow()

    fun loadAllFoodData(){
        viewModelScope.launch {
            val foodData = getAllFoodData()

            _viewState.update { currentState ->
                currentState.copy(
                    foodData = foodData
                )

            }
        }
    }
}
package com.example.foodshop.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.foodshop.presentation.navigation.AppDestination
import com.example.foodshop.presentation.screens.components.BottomNavigate
import com.example.foodshop.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
) {
    val state by vm.viewState.collectAsState()
    Log.d("MainScreen", state.toString())
//    vm.loadAllFoodData()


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        BottomNavigate(
            navController = navController,
            currentScreen = currentScreen,
        )
    }
}
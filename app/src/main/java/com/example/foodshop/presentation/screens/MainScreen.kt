package com.example.foodshop.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.foodshop.presentation.navigation.AppDestination
import com.example.foodshop.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
) {
    Text(text = "Main Screen")
}
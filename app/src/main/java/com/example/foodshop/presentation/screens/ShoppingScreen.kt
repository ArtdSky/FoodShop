package com.example.foodshop.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.foodshop.presentation.navigation.AppDestination
import com.example.foodshop.presentation.screens.components.BottomNavigate
import com.example.foodshop.presentation.viewmodel.MainViewModel

@Composable
fun ShoppingScreen(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
) {
    Text(text = "Shopping-cart screen development in progress")



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
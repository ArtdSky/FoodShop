package com.example.foodshop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodshop.presentation.screens.MainScreen
import com.example.foodshop.presentation.screens.ProfileScreen
import com.example.foodshop.presentation.screens.ShoppingScreen
import com.example.foodshop.presentation.viewmodel.MainViewModel

/**
 * Функция для создания графа навигации.
 *
 * @param navController контроллер навигации.
 * @param currentScreen текущий экран приложения.
 * @param vm ViewModel, используемая для управления состоянием экрана.
 */
@Composable
fun NavGraph(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.route,

        ) {
        composable(route = MainScreen.route) {
            MainScreen(
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

        composable(route = ProfileScreen.route) {
            ProfileScreen(
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

        composable(route = ShoppingScreen.route) {
            ShoppingScreen(
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

    }

}
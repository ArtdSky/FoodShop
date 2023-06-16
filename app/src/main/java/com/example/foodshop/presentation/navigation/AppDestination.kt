package com.example.foodshop.presentation.navigation

interface AppDestination {
    val route : String
}

object MainScreen : AppDestination{
    override val route: String
        get() = "main"
}

object ProfileScreen : AppDestination{
    override val route: String
        get() = "profile"
}

object ShoppingScreen : AppDestination{
    override val route: String
        get() = "shopcart"
}

val AppTabRowScreens = listOf(MainScreen, ProfileScreen, ShoppingScreen)
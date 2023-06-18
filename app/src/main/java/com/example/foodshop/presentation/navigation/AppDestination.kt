package com.example.foodshop.presentation.navigation

/**
 * Интерфейс, представляющий маршрут навигации приложения.
 */
interface AppDestination {
    val route : String
}
/**
 * Объект, представляющий главный экран приложения.
 */
object MainScreen : AppDestination{
    override val route: String
        get() = "main"
}
/**
 * Объект, представляющий экран профиля пользователя.
 */
object ProfileScreen : AppDestination{
    override val route: String
        get() = "profile"
}
/**
 * Объект, представляющий экран корзины покупок.
 */
object ShoppingScreen : AppDestination{
    override val route: String
        get() = "shopcart"
}

/**
 * Список экранов, доступных в нижней навигационной панели.
 */
val AppTabRowScreens = listOf(MainScreen, ProfileScreen, ShoppingScreen)
package com.example.foodshop.domain.models

data class FoodData(
    val menu: MenuData
)

data class MenuData(
    val pizzas: List<PizzaData>,
    val combos: List<ComboData>,
    val desserts: List<DessertData>,
    val drinks: List<DrinkData>
)

data class PizzaData(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Int
)

data class ComboData(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Int
)

data class DessertData(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Int
)

data class DrinkData(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Int
)


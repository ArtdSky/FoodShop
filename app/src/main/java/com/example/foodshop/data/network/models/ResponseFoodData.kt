package com.example.foodshop.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseFoodData(
    @Json(name = "menu")
    val menu: MenuData
)

@JsonClass(generateAdapter = true)
data class MenuData(
    @Json(name = "pizzas")
    val pizzas: List<PizzaData>,
    @Json(name = "combos")
    val combos: List<ComboData>,
    @Json(name = "desserts")
    val desserts: List<DessertData>,
    @Json(name = "drinks")
    val drinks: List<DrinkData>
)

@JsonClass(generateAdapter = true)
data class PizzaData(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "price")
    val price: Int
)

@JsonClass(generateAdapter = true)
data class ComboData(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "price")
    val price: Int
)

@JsonClass(generateAdapter = true)
data class DessertData(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "price")
    val price: Int
)

@JsonClass(generateAdapter = true)
data class DrinkData(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "price")
    val price: Int
)


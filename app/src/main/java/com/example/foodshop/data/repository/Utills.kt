package com.example.foodshop.data.repository

import com.example.foodshop.domain.models.FoodData
import com.example.foodshop.data.network.models.MenuData as NetworkMenuData
import com.example.foodshop.domain.models.MenuData as DomainMenuData

fun mapMenuDataToDomain(networkMenuData: NetworkMenuData): FoodData {
    return FoodData(DomainMenuData(
        pizzas = networkMenuData.pizzas.map { mapPizzaDataToDomain(it) },
        combos = networkMenuData.combos.map { mapComboDataToDomain(it) },
        desserts = networkMenuData.desserts.map { mapDessertDataToDomain(it) },
        drinks = networkMenuData.drinks.map { mapDrinkDataToDomain(it) }
    ))
}

fun mapPizzaDataToDomain(networkPizzaData: com.example.foodshop.data.network.models.PizzaData): com.example.foodshop.domain.models.PizzaData {
    return networkPizzaData.let {
        com.example.foodshop.domain.models.PizzaData(
            id = it.id,
            name = it.name,
            description = it.description,
            image = it.image,
            price = it.price
        )
    }
}

fun mapComboDataToDomain(networkComboData: com.example.foodshop.data.network.models.ComboData): com.example.foodshop.domain.models.ComboData {
    return networkComboData.let {
        com.example.foodshop.domain.models.ComboData(
            id = it.id,
            name = it.name,
            description = it.description,
            image = it.image,
            price = it.price
        )
    }
}

fun mapDessertDataToDomain(networkDessertData: com.example.foodshop.data.network.models.DessertData): com.example.foodshop.domain.models.DessertData {
    return networkDessertData.let {
        com.example.foodshop.domain.models.DessertData(
            id = it.id,
            name = it.name,
            description = it.description,
            image = it.image,
            price = it.price
        )
    }
}

fun mapDrinkDataToDomain(networkDrinkData: com.example.foodshop.data.network.models.DrinkData): com.example.foodshop.domain.models.DrinkData {
    return networkDrinkData.let {
        com.example.foodshop.domain.models.DrinkData(
            id = it.id,
            name = it.name,
            description = it.description,
            image = it.image,
            price = it.price
        )
    }
}

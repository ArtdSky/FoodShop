package com.example.foodshop.presentation.di

import com.example.foodshop.data.repository.RepositoryImpl
import com.example.foodshop.data.storage.ApiStorage
import com.example.foodshop.data.storage.Storage
import com.example.foodshop.domain.repository.FoodRepository
import com.example.foodshop.domain.usecases.GetAllFoodData
import com.example.foodshop.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module{
    // ViewModel
    viewModel { MainViewModel( get()) }

    // UseCase
    factory { GetAllFoodData(get()) }

    // Repository
    single<FoodRepository> { RepositoryImpl(get()) }

    single<Storage> { ApiStorage() }
}
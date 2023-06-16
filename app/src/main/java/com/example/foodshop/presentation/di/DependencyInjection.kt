package com.example.foodshop.presentation.di

import com.example.foodshop.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module{
    // ViewModel
    viewModel { MainViewModel() }

}
package com.example.foodshop

import android.app.Application
import com.example.foodshop.presentation.di.DependencyInjection
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FoodApplication)
            modules(listOf( DependencyInjection) )
        }
    }
}
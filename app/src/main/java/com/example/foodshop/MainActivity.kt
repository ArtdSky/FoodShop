package com.example.foodshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.foodshop.presentation.navigation.NavState
import com.example.foodshop.presentation.viewmodel.MainViewModel
import com.example.foodshop.ui.theme.FoodShopTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodShopTheme{
                MainActivityScreen()
            }
        }
    }
}
@Composable
fun MainActivityScreen() {
    val myViewModel: MainViewModel = koinViewModel()
    NavState(vm = myViewModel)
}
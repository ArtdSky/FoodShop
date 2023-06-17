package com.example.foodshop.presentation.screens.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodshop.presentation.navigation.AppDestination
import com.example.foodshop.presentation.navigation.MainScreen
import com.example.foodshop.presentation.navigation.ProfileScreen
import com.example.foodshop.presentation.navigation.ShoppingScreen
import com.example.foodshop.presentation.navigation.navigateSingleTopTo
import com.example.foodshop.R as Res

@Composable
fun BottomNavigate(
    navController: NavHostController,
    currentScreen: AppDestination,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFFF0F0F0))
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(120.dp)
                .height(56.dp)
        ) {
            val isSelected =
                currentScreen.route == MainScreen.route // Проверка, является ли текущий экран экраном меню
            val color =
                if (isSelected) Color(0xFFFD3A69) else Color(0xFF263238) // Определение цвета иконки и текста в зависимости от выбора
            Image(
                painter = painterResource(id = Res.drawable.menu),
                contentDescription = "Меню",
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = {
                        Log.d(
                            "Bottom-Nav",
                            "${currentScreen.route}  CLICKED"
                        )
                        navController.navigateSingleTopTo(MainScreen.route)
                    }),
                colorFilter = ColorFilter.tint(color)
            )
            Text(
                text = "Меню",
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(Res.font.inter)),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = color // Установка цвета текста
                )
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(120.dp)
                .height(56.dp)
        ) {
            val isSelected = currentScreen.route == ProfileScreen.route
            val color = if (isSelected) Color(0xFFFD3A69) else Color(0xFF263238)
            Image(
                painter = painterResource(id = Res.drawable.profile),
                contentDescription = "Профиль",
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = {
                        Log.d(
                            "Bottom-Nav",
                            "${currentScreen.route}  CLICKED"
                        )
                        navController.navigateSingleTopTo(ProfileScreen.route)
                    }),
                colorFilter = ColorFilter.tint(color)
            )
            Text(
                text = "Профиль",
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(Res.font.inter)),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = color
                )
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(120.dp)
                .height(56.dp)
        ) {
            val isSelected = currentScreen.route == ShoppingScreen.route
            val color = if (isSelected) Color(0xFFFD3A69) else Color(0xFF263238)
            Image(
                painter = painterResource(id = Res.drawable.shopcart),
                contentDescription = "Корзина",
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = {
                        Log.d(
                            "Bottom-Nav",
                            "${currentScreen.route}  CLICKED"
                        )
                        navController.navigateSingleTopTo(ShoppingScreen.route)
                    }),
                colorFilter = ColorFilter.tint(color)
            )
            Text(
                text = "Корзина",
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(Res.font.inter)),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = color
                )
            )
        }

    }
}

package com.example.foodshop.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.TypedArrayUtils.getResourceId
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.foodshop.R
import com.example.foodshop.presentation.navigation.AppDestination
import com.example.foodshop.presentation.navigation.navigateSingleTopTo
import com.example.foodshop.presentation.screens.components.BottomNavigate
import com.example.foodshop.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun MainScreen(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
) {
    val state by vm.viewState.collectAsState()
    Log.d("MainScreen", state.toString())
    vm.loadAllFoodData()

    val scrollState = rememberLazyListState()
    var isScrolled by remember { mutableStateOf(false) }

    LaunchedEffect(scrollState.isScrollInProgress) {
        if (scrollState.isScrollInProgress && !isScrolled) {
            isScrolled = true
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 40.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Москва")
                    Spacer(modifier = Modifier.width(14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.arrow_down),
                        contentDescription = "Arrow down",
                        modifier = Modifier
                            .width(12.dp)
                            .height(8.dp)
                            .clickable(onClick = {
                                Log.d(
                                    "MainScreen",
                                    "Arrow down  clicked"
                                )
                            })
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.qrcode),
                    contentDescription = "Qr code",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = {
                            Log.d(
                                "MainScreen",
                                "Qr code  clicked"
                            )
                        })
                )
            }

            Spacer(modifier = Modifier.height(34.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val banners = listOf(
                    R.drawable.banner1,
                    R.drawable.banner2
                )
                items(banners.size) { index ->
                    if (!isScrolled) {
                        Card(
                            modifier = Modifier
                                .width(300.dp)
                                .height(112.dp)
                        ) {
                            Image(
                                painter = painterResource(
                                    banners[index]
                                ),
                                contentDescription = "banner ${banners[index]}",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            val categories = listOf("Пицца", "Комбо", "Десерты", "Напитки")
            var selectedCategory by remember { mutableStateOf(categories[0]) }


            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.size) { index ->
                    val isSelected = categories[index] == selectedCategory

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp)
                            .padding(horizontal = 8.dp)
                            .background(
                                color = if (isSelected) {
                                    Color(0x33FF3A69)
                                } else {
                                    Color(0xFFFFFFFF)
                                }
                            )
                    ) {
                        Button(
                            onClick = { selectedCategory = categories[index] },
                            colors = buttonColors(
                                containerColor = if (isSelected) {
                                    Color(0x33FF3A69)
                                } else {
                                    Color(0xFFFFFFFF)
                                },
                                contentColor = Color(0xFFC3C4C9),
                            ),
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = categories[index],
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W400,
                                lineHeight = 16.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                color = if (isSelected) {
                                    Color(0xFFFD3A69)
                                } else {
                                    Color(0xFFC3C4C9)
                                }
                            )
                        }
                    }
                }
            }


            Spacer(modifier = Modifier.height(16.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(bottom = 36.dp)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    state = scrollState,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    when (selectedCategory) {
                        "Пицца" -> {
                            isScrolled = false
                            state.foodData?.menu?.pizzas?.let {
                                items(it.size) { pizzaIndex ->

                                    Row {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(state.foodData!!.menu.pizzas[pizzaIndex].image)
                                                .build(),
                                            contentDescription = state.foodData!!.menu.pizzas[pizzaIndex].name,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(135.dp)

                                        )
                                        Spacer(modifier = Modifier.width(22.dp))
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.Start,
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxSize()
                                                .width(75.dp)
                                        ) {
                                            Text(
                                                text = state.foodData!!.menu.pizzas[pizzaIndex].name,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W700,
                                                fontSize = 16.sp,
                                                lineHeight = (18.75).sp,
                                                color = Color(0xFF222831),
                                                textAlign = TextAlign.Start,
                                            )
                                            Text(
                                                text = state.foodData!!.menu.pizzas[pizzaIndex].description,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W400,
                                                fontSize = 14.sp,
                                                lineHeight = (16.71).sp,
                                                color = Color(0xFFAAAAAD),
                                                modifier = Modifier.padding(top = 4.dp)
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(
                                                        vertical = 8.dp,
                                                        horizontal = 16.dp
                                                    ),
                                                contentAlignment = Alignment.CenterEnd
                                            ) {
                                                Button(
                                                    onClick = {
                                                        Log.d(
                                                            "MainScreen",
                                                            "Button pressed ${state.foodData!!.menu.pizzas[pizzaIndex].price}"
                                                        )
                                                    },
                                                    shape = RoundedCornerShape(6.dp),
                                                    colors = buttonColors(
                                                        containerColor = Color.White,
                                                        contentColor = Color.White
                                                    ),
                                                    modifier = Modifier
                                                        .border(
                                                            2.dp,
                                                            Color(0xFFFD3A69),
                                                            RoundedCornerShape(6.dp)
                                                        )
                                                        .height(34.dp)
                                                        .width(87.dp)

                                                ) {
                                                    Text(
                                                        text = "от ${state.foodData!!.menu.pizzas[pizzaIndex].price} р",
                                                        fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                        fontWeight = FontWeight.W400,
                                                        fontSize = 10.sp,
                                                        lineHeight = (16).sp,
                                                        color = Color(0xFFFD3A69),

                                                        )
                                                }
                                            }
                                        }
                                    }


                                }
                            }
                        }

                        "Комбо" -> {
                            isScrolled = false
                            state.foodData?.menu?.combos?.let {
                                items(it.size) { comboIndex ->
                                    // Отобразить данные комбо
                                    Row {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(state.foodData!!.menu.combos[comboIndex].image)
                                                .build(),
                                            contentDescription = state.foodData!!.menu.combos[comboIndex].name,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(135.dp)

                                        )
                                        Spacer(modifier = Modifier.width(22.dp))
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.Start,
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxSize()
                                                .width(75.dp)
                                        ) {
                                            Text(
                                                text = state.foodData!!.menu.combos[comboIndex].name,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W700,
                                                fontSize = 16.sp,
                                                lineHeight = (18.75).sp,
                                                color = Color(0xFF222831),
                                                textAlign = TextAlign.Start,
                                            )
                                            Text(
                                                text = state.foodData!!.menu.combos[comboIndex].description,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W400,
                                                fontSize = 14.sp,
                                                lineHeight = (16.71).sp,
                                                color = Color(0xFFAAAAAD),
                                                modifier = Modifier.padding(top = 4.dp)
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(
                                                        vertical = 8.dp,
                                                        horizontal = 16.dp
                                                    ),
                                                contentAlignment = Alignment.CenterEnd
                                            ) {
                                                Button(
                                                    onClick = {
                                                        Log.d(
                                                            "MainScreen",
                                                            "Button pressed ${state.foodData!!.menu.combos[comboIndex].price}"
                                                        )
                                                    },
                                                    shape = RoundedCornerShape(6.dp),
                                                    colors = buttonColors(
                                                        containerColor = Color.White,
                                                        contentColor = Color.White
                                                    ),
                                                    modifier = Modifier
                                                        .border(
                                                            2.dp,
                                                            Color(0xFFFD3A69),
                                                            RoundedCornerShape(6.dp)
                                                        )
                                                        .height(34.dp)
                                                        .width(87.dp)

                                                ) {
                                                    Text(
                                                        text = "от ${state.foodData!!.menu.combos[comboIndex].price} р",
                                                        fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                        fontWeight = FontWeight.W400,
                                                        fontSize = 10.sp,
                                                        lineHeight = (16).sp,
                                                        color = Color(0xFFFD3A69),
                                                        )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        "Десерты" -> {
                            isScrolled = false
                            state.foodData?.menu?.desserts?.let {
                                items(it.size) { dessertIndex ->
                                    // Отобразить данные десерта
                                    Row {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(state.foodData!!.menu.desserts[dessertIndex].image)
                                                .build(),
                                            contentDescription = state.foodData!!.menu.desserts[dessertIndex].name,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(135.dp)

                                        )
                                        Spacer(modifier = Modifier.width(22.dp))
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.Start,
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxSize()
                                                .width(75.dp)
                                        ) {
                                            Text(
                                                text = state.foodData!!.menu.desserts[dessertIndex].name,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W700,
                                                fontSize = 16.sp,
                                                lineHeight = (18.75).sp,
                                                color = Color(0xFF222831),
                                                textAlign = TextAlign.Start,
                                            )
                                            Text(
                                                text = state.foodData!!.menu.desserts[dessertIndex].description,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W400,
                                                fontSize = 14.sp,
                                                lineHeight = (16.71).sp,
                                                color = Color(0xFFAAAAAD),
                                                modifier = Modifier.padding(top = 4.dp)
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(
                                                        vertical = 8.dp,
                                                        horizontal = 16.dp
                                                    ),
                                                contentAlignment = Alignment.CenterEnd
                                            ) {
                                                Button(
                                                    onClick = {
                                                        Log.d(
                                                            "MainScreen",
                                                            "Button pressed ${state.foodData!!.menu.desserts[dessertIndex].price}"
                                                        )
                                                    },
                                                    shape = RoundedCornerShape(6.dp),
                                                    colors = buttonColors(
                                                        containerColor = Color.White,
                                                        contentColor = Color.White
                                                    ),
                                                    modifier = Modifier
                                                        .border(
                                                            2.dp,
                                                            Color(0xFFFD3A69),
                                                            RoundedCornerShape(6.dp)
                                                        )
                                                        .height(34.dp)
                                                        .width(87.dp)

                                                ) {
                                                    Text(
                                                        text = "от ${state.foodData!!.menu.desserts[dessertIndex].price} р",
                                                        fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                        fontWeight = FontWeight.W400,
                                                        fontSize = 10.sp,
                                                        lineHeight = (16).sp,
                                                        color = Color(0xFFFD3A69),
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        "Напитки" -> {
                            isScrolled = false
                            state.foodData?.menu?.drinks?.let {
                                items(it.size) { drinkIndex ->
                                    // Отобразить данные напитка
                                    Row {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(state.foodData!!.menu.drinks[drinkIndex].image)
                                                .build(),
                                            contentDescription = state.foodData!!.menu.drinks[drinkIndex].name,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(135.dp)

                                        )
                                        Spacer(modifier = Modifier.width(22.dp))
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.Start,
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxSize()
                                                .width(75.dp)
                                        ) {
                                            Text(
                                                text = state.foodData!!.menu.drinks[drinkIndex].name,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W700,
                                                fontSize = 16.sp,
                                                lineHeight = (18.75).sp,
                                                color = Color(0xFF222831),
                                                textAlign = TextAlign.Start,
                                            )
                                            Text(
                                                text = state.foodData!!.menu.drinks[drinkIndex].description,
                                                fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                fontWeight = FontWeight.W400,
                                                fontSize = 14.sp,
                                                lineHeight = (16.71).sp,
                                                color = Color(0xFFAAAAAD),
                                                modifier = Modifier.padding(top = 4.dp)
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(
                                                        vertical = 8.dp,
                                                        horizontal = 16.dp
                                                    ),
                                                contentAlignment = Alignment.CenterEnd
                                            ) {
                                                Button(
                                                    onClick = {
                                                        Log.d(
                                                            "MainScreen",
                                                            "Button pressed ${state.foodData!!.menu.drinks[drinkIndex].price}"
                                                        )
                                                    },
                                                    shape = RoundedCornerShape(6.dp),
                                                    colors = buttonColors(
                                                        containerColor = Color.White,
                                                        contentColor = Color.White
                                                    ),
                                                    modifier = Modifier
                                                        .border(
                                                            2.dp,
                                                            Color(0xFFFD3A69),
                                                            RoundedCornerShape(6.dp)
                                                        )
                                                        .height(34.dp)
                                                        .width(87.dp)

                                                ) {
                                                    Text(
                                                        text = "от ${state.foodData!!.menu.drinks[drinkIndex].price} р",
                                                        fontFamily = FontFamily(Font(R.font.sfuidisplay)),
                                                        fontWeight = FontWeight.W400,
                                                        fontSize = 10.sp,
                                                        lineHeight = (16).sp,
                                                        color = Color(0xFFFD3A69),
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            BottomNavigate(
                navController = navController,
                currentScreen = currentScreen,
            )
        }
    }
}
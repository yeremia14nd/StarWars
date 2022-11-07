package com.example.starwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.starwars.starwarslist.StarwarsListScreen
import com.example.starwars.ui.theme.StarWarsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarWarsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "starwars_home_screen"
                ) {
                    composable("starwars_home_screen") {
                        StarwarsListScreen(navController = navController)
                    }
                    composable(
                        "category_list_screen/{categoryName}",
                        arguments = listOf(
                            navArgument("categoryName") {
                                type = NavType.StringType
                            }
                        )
                    ){
                        val categoryName = remember {
                            it.arguments?.getString("categoryName")
                        }
                    }
                    composable(
                        "detail_screen/{dominantColor}/{itemName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("itemName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) ?: Color.White}
                        }
                        val itemName = remember {
                            it.arguments?.getString("itemName")
                        }
                    }
                }
            }
        }
    }
}
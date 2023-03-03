package com.mmaquera.netgame.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mmaquera.netgame.ui.screen.LoginScreen
import com.mmaquera.netgame.ui.screen.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen {
                navController.navigate("main")
            }
        }
        composable("main") {
            MainScreen()
        }
    }
}
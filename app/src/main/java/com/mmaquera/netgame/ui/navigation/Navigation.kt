package com.mmaquera.netgame.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mmaquera.netgame.ui.screen.MainScreen
import com.mmaquera.netgame.view.login.signin.LoginScreen
import com.mmaquera.netgame.view.login.signup.SignUpScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                goToMainScreen = { navController.navigate("main") },
                goToSignUpScreen = { navController.navigate("signUp") }
            )
        }
        composable("main") {
            MainScreen {
                navController.popBackStack()
            }
        }
        composable("signUp") {
            SignUpScreen {
                navController.popBackStack()
            }
        }
    }
}
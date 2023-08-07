package dev.vengateshm.petcareapp.android.presentation.screens.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.onBoardingNavGraph(navController: NavController) {
    navigation(
        route = "onboarding",
        startDestination = "sSplash"
    ) {
        composable(
            route = "sSplash"
        ) {
            SplashScreen(
                onTimeOut = {
                    navController.navigate("sWelcome")
                })
        }
        composable(
            route = "sWelcome"
        ) {
            WelcomeScreen()
        }
    }
}
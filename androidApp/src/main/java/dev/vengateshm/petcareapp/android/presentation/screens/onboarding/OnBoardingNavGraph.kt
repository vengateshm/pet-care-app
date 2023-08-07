package dev.vengateshm.petcareapp.android.presentation.screens.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.onBoardingNavGraph(navController: NavController, isLoggedIn: Boolean) {
    navigation(
        route = "onboarding",
        startDestination = "sSplash"
    ) {
        composable(
            route = "sSplash"
        ) {
            SplashScreen(
                onTimeOut = {
                    if (isLoggedIn)
                        navController.navigate("main") {
                            popUpTo("onboarding")
                        }
                    else
                        navController.navigate("sWelcome")
                })
        }
        composable(
            route = "sWelcome"
        ) {
            WelcomeScreen(
                onSignInClicked = {
                    navController.navigate("login") {
                        popUpTo(route = "onboarding")
                    }
                },
                onGetStartedClicked = {
                    navController.navigate("signup_landing") {
                        popUpTo(route = "onboarding")
                    }
                }
            )
        }
    }
}
package dev.vengateshm.petcareapp.android.presentation.screens.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.vengateshm.petcareapp.android.presentation.screens.AppScreen

fun NavGraphBuilder.onBoardingNavGraph(navController: NavController, isLoggedIn: Boolean) {
    navigation(
        route = AppScreen.Onboarding.route,
        startDestination = AppScreen.Onboarding.Splash.route
    ) {
        composable(
            route = AppScreen.Onboarding.Splash.route
        ) {
            SplashScreen(onTimeOut = {
                if (isLoggedIn) navController.navigate(AppScreen.MainLanding.route) {
                    popUpTo(AppScreen.Onboarding.route)
                }
                else navController.navigate(AppScreen.Onboarding.Welcome.route)
            })
        }
        composable(
            route = AppScreen.Onboarding.Welcome.route
        ) {
            WelcomeScreen(onSignInClicked = {
                navController.navigate(AppScreen.Auth.SignIn.route) {
                    popUpTo(route = AppScreen.Onboarding.route)
                }
            }, onGetStartedClicked = {
                navController.navigate(AppScreen.Auth.SignUpLanding.route) {
                    popUpTo(route = AppScreen.Onboarding.route)
                }
            })
        }
    }
}
package dev.vengateshm.petcareapp.android.presentation.screens.auth

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.vengateshm.petcareapp.android.presentation.screens.AppScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        route = AppScreen.Auth.route,
        startDestination = AppScreen.Auth.SignIn.route
    ) {
        composable(route = AppScreen.Auth.SignIn.route) {
            LoginScreen(
                onLoggedIn = {
                    navController.navigate(AppScreen.MainLanding.route) {
                        popUpTo(route = AppScreen.Auth.route)
                    }
                },
                onSignUpClicked = {
                    NavBackStackEntry
                    navController.navigate(AppScreen.Auth.SignUpLanding.route)
                }
            )
        }
        composable(route = AppScreen.Auth.SignUpLanding.route) {
            SignupLandingScreen(
                onRegisterWithEmailClicked = {
                    navController.navigate(AppScreen.Auth.SignUp.route)
                },
                onSignInClicked = {
                    navController.navigate(AppScreen.Auth.SignIn.route)
                },
                onSignedUp = {
                    navController.navigate(AppScreen.Auth.SignIn.route)
                }
            )
        }
        composable(route = AppScreen.Auth.SignUp.route) {
            SignupScreen(
                onSignedUp = {
                    navController.popBackStack()
                    navController.navigate(AppScreen.Auth.SignIn.route)
                }
            )
        }
    }
}
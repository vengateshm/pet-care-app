package dev.vengateshm.petcareapp.android.presentation.screens.auth

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(route = "auth", startDestination = "login") {
        composable(route = "login") {
            LoginScreen(
                onLoggedIn = {
                    navController.navigate("home") {
                        popUpTo(route = "auth")
                    }
                },
                onSignUpClicked = {
                    NavBackStackEntry
                    navController.navigate("signup_landing")
                }
            )
        }
        composable(route = "signup_landing") {
            SignupLandingScreen(
                onRegisterWithEmailClicked = {
                    navController.navigate("signup")
                },
                onSignInClicked = {
                    navController.navigate("login")
                },
                onSignedUp = {
                    navController.navigate("login")
                }
            )
        }
        composable(route = "signup") {
            SignupScreen(
                onSignedUp = {
                    navController.popBackStack()
                    navController.navigate("login")
                }
            )
        }
    }
}
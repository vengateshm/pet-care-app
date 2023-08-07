package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(route = "main", startDestination = "home") {
        composable(route = "home") {
            HomeScreen()
        }
    }
}
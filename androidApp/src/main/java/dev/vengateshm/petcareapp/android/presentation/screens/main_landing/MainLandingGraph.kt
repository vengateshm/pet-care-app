package dev.vengateshm.petcareapp.android.presentation.screens.main_landing

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.vengateshm.petcareapp.android.presentation.screens.AppScreen

fun NavGraphBuilder.mainLandingGraph() {
    navigation(
        route = AppScreen.MainLanding.route,
        startDestination = AppScreen.MainLanding.Main.route
    ) {
        composable(route = AppScreen.MainLanding.Main.route) {
            MainLandingScreen()
        }
    }
}
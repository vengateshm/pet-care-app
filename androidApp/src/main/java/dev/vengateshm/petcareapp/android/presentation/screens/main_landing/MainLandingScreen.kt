package dev.vengateshm.petcareapp.android.presentation.screens.main_landing

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.vengateshm.petcareapp.android.presentation.screens.home.AppointmentsScreen
import dev.vengateshm.petcareapp.android.presentation.screens.home.HomeScreen
import dev.vengateshm.petcareapp.android.presentation.screens.home.ProfileScreen

@Composable
fun MainLandingScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = BottomNavScreen.Search.route
        ) {
            composable(route = BottomNavScreen.Search.route) {
                HomeScreen()
            }
            composable(route = BottomNavScreen.Appointments.route) {
                AppointmentsScreen()
            }
            composable(route = BottomNavScreen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}
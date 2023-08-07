package dev.vengateshm.petcareapp.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.vengateshm.petcareapp.android.presentation.screens.onboarding.onBoardingNavGraph
import dev.vengateshm.petcareapp.android.ui.theme.PetCareAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PetCareAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "onboarding"
                ) {
                    onBoardingNavGraph(navController = navController)
                }
            }
        }
    }
}
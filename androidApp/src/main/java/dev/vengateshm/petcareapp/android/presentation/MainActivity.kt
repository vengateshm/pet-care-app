package dev.vengateshm.petcareapp.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.vengateshm.petcareapp.android.presentation.screens.auth.authNavGraph
import dev.vengateshm.petcareapp.android.presentation.screens.home.homeNavGraph
import dev.vengateshm.petcareapp.android.presentation.screens.onboarding.onBoardingNavGraph
import dev.vengateshm.petcareapp.android.ui.theme.PetCareAppTheme
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {

    private val preferenceProvider: PreferenceProvider by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isLoggedIn = preferenceProvider.getString(PreferenceProvider.KEY_TOKEN).isNotEmpty()

        setContent {
            PetCareAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "onboarding"
                ) {
                    onBoardingNavGraph(navController = navController, isLoggedIn)
                    authNavGraph(navController = navController)
                    homeNavGraph(navController = navController)
                }
            }
        }
    }
}
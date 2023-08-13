package dev.vengateshm.petcareapp.android.presentation.screens.main_landing

import androidx.compose.ui.graphics.vector.ImageVector
import dev.vengateshm.petcareapp.android.presentation.imageVectors.ClockIcon
import dev.vengateshm.petcareapp.android.presentation.imageVectors.ProfileIcon
import dev.vengateshm.petcareapp.android.presentation.imageVectors.SearchIcon

sealed class BottomNavScreen(val route: String, val name: String, val icon: ImageVector) {
    object Search : BottomNavScreen("bottom_nav_search", "Search", SearchIcon)
    object Appointments : BottomNavScreen("appointment", "Appointments", ClockIcon)
    object Profile : BottomNavScreen("profile", "Profile", ProfileIcon)
}
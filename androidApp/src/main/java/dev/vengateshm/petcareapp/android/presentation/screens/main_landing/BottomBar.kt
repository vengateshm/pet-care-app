package dev.vengateshm.petcareapp.android.presentation.screens.main_landing

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.vengateshm.petcareapp.android.ui.theme.AppBlue
import dev.vengateshm.petcareapp.android.ui.theme.BottomBarContainer

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val screens = remember {
        listOf(
            BottomNavScreen.Search,
            BottomNavScreen.Appointments,
            BottomNavScreen.Profile
        )
    }

    NavigationBar(
        modifier = modifier,
        containerColor = BottomBarContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            NavigationBarItem(
                label = {
                    Text(text = screen.name)
                },
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = "")
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = AppBlue,
                    unselectedTextColor = Color.Gray,
                    selectedIconColor = AppBlue,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = BottomBarContainer
                ),
            )
        }
    }
}
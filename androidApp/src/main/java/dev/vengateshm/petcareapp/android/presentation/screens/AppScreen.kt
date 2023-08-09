package dev.vengateshm.petcareapp.android.presentation.screens

sealed class AppScreen(val route: String) {
    sealed class Auth(route: String) : AppScreen(route) {
        companion object {
            const val route = "auth_nav_graph"
        }

        object SignIn : Auth("signIn")
        object SignUp : Auth("signUp")
        object SignUpLanding : Auth("signUpLanding")
    }

    sealed class Onboarding(route: String) : AppScreen(route) {
        companion object {
            const val route = "onboarding_nav_graph"
        }

        object Splash : Onboarding("splash")
        object Welcome : Onboarding("welcome")
    }

    sealed class MainLanding(route: String) : AppScreen(route) {
        companion object {
            const val route = "main_nav_graph"
        }

        object Main : MainLanding("main")
    }
}
package dev.vengateshm.petcareapp.android.presentation.screens.onboarding

data class WelcomeData(
    val title: String,
    val description: String,
    val imageRes: Int,
)

val welcomeDataList by lazy {
    listOf(
        WelcomeData(
            title = "Welcome to Pet Care",
            description = "All types of services for your pet in one place, instantly searchable.",
            imageRes = dev.vengateshm.petcareapp.android.R.drawable.welcome_1
        ),
        WelcomeData(
            title = "Proven experts",
            description = "We interview every specialist before they get to work.",
            imageRes = dev.vengateshm.petcareapp.android.R.drawable.welcome_2
        ),
        WelcomeData(
            title = "Reliable reviews",
            description = "A review can be left only by a user who used the service.",
            imageRes = dev.vengateshm.petcareapp.android.R.drawable.welcome_3
        )
    )
}
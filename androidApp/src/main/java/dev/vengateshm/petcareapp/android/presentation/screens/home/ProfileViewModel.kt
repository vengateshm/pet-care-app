package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.lifecycle.ViewModel
import dev.vengateshm.petcareapp.platform.PreferenceProvider

class ProfileViewModel(
    private val preferenceProvider: PreferenceProvider
) : ViewModel() {
    val userName = preferenceProvider.getString(PreferenceProvider.KEY_USER_NAME)
}
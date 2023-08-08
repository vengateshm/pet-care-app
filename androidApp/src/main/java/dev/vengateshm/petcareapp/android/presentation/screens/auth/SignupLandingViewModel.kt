package dev.vengateshm.petcareapp.android.presentation.screens.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.usecase.SignupUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupLandingViewModel(private val signupUseCase: SignupUseCase) : ViewModel() {
    var uiState by mutableStateOf(SignupLandingUiState())

    fun signupWithGoogle(idToken: String) {
        viewModelScope.launch(Dispatchers.IO) {
            uiState = uiState.copy(isLoading = true)
            val result = signupUseCase.signupWithGoogle(idToken)
            uiState =
                uiState.copy(isLoading = false, isSignedUp = result != null && result.id != 0)
        }
    }
}

data class SignupLandingUiState(
    val isLoading: Boolean = false,
    val isSignedUp: Boolean = false,
)
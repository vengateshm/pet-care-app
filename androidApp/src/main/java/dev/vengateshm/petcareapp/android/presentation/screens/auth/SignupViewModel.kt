package dev.vengateshm.petcareapp.android.presentation.screens.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.usecase.SignupUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupViewModel(private val signupUseCase: SignupUseCase) : ViewModel() {
    var uiState by mutableStateOf(SignupUiState())

    fun signup(name: String, email: String, password: String) {
        if (name.isEmpty()) {
            uiState = uiState.copy(isNameError = true)
            return
        }
        if (email.isEmpty()) {
            uiState = uiState.copy(isEmailError = true)
            return
        }
        if (password.isEmpty()) {
            uiState = uiState.copy(isPasswordError = true)
            return
        }
        if (password.length < 8) {
            uiState = uiState.copy(isPasswordError = true)
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            uiState = uiState.copy(isLoading = true)
            val result = signupUseCase(name, email, password)
            uiState =
                uiState.copy(isLoading = false, isSignedUp = result != null && result.id != 0)
        }
    }
}

data class SignupUiState(
    val isNameError: Boolean = false,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isLoading: Boolean = false,
    val isSignedUp: Boolean = false,
)
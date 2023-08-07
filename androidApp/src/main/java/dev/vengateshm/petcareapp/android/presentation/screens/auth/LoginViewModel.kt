package dev.vengateshm.petcareapp.android.presentation.screens.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
    fun login(email: String, password: String) {
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
            val result = loginUseCase(email, password)
            uiState = uiState.copy(isLoading = false, isLoggedIn = result)
        }
    }
}

data class LoginUiState(
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
)
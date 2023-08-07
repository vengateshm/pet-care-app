package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.entity.ServicesOffered
import dev.vengateshm.petcareapp.domain.usecase.ServicesOfferedUseCase
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import kotlinx.coroutines.launch

class HomeViewModel(
    private val servicesOfferedUseCase: ServicesOfferedUseCase,
    private val preferenceProvider: PreferenceProvider,
) : ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())

    init {
        getAllServicesOffered()
    }

    private fun getAllServicesOffered() {
        viewModelScope.launch {
            val userName = preferenceProvider.getString(PreferenceProvider.KEY_USER_NAME)
            uiState = uiState.copy(loading = true, userName = userName)
            uiState = try {
                val result = servicesOfferedUseCase()
                uiState.copy(servicesOfferedList = result, loading = false)
            } catch (e: Exception) {
                uiState.copy(
                    errorMessage = "Error loading services offered list ${if (!e.localizedMessage.isNullOrEmpty()) " : ${e.localizedMessage}" else ""}",
                    loading = false
                )
            }
        }
    }
}

data class HomeScreenState(
    var loading: Boolean = false,
    var servicesOfferedList: List<ServicesOffered> = emptyList(),
    var errorMessage: String = "",
    var userName: String = "",
)
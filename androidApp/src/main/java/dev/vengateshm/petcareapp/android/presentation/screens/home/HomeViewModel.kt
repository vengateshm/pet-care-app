package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.entity.AppService
import dev.vengateshm.petcareapp.domain.usecase.AppServiceUseCase
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import kotlinx.coroutines.launch

class HomeViewModel(
    private val appServiceUseCase: AppServiceUseCase,
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
                val result = appServiceUseCase()
                uiState.copy(appServiceList = result, loading = false)
            } catch (e: Exception) {
                uiState.copy(
                    errorMessage = "Error loading app service list ${if (!e.localizedMessage.isNullOrEmpty()) " : ${e.localizedMessage}" else ""}",
                    loading = false
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}

data class HomeScreenState(
    var loading: Boolean = false,
    var appServiceList: List<AppService> = emptyList(),
    var errorMessage: String = "",
    var userName: String = "",
)
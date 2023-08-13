package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.entity.AppService
import dev.vengateshm.petcareapp.domain.entity.Specialization
import dev.vengateshm.petcareapp.domain.usecase.AppServiceUseCase
import dev.vengateshm.petcareapp.domain.usecase.PhysicianUseCase
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val appServiceUseCase: AppServiceUseCase,
    private val physicianUseCase: PhysicianUseCase,
    private val preferenceProvider: PreferenceProvider,
) : ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())
    var specializationDialogState by mutableStateOf(SpecializationDialogState())

    init {
        getAllServicesOffered()
    }

    private fun getAllServicesOffered() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val userName = preferenceProvider.getString(PreferenceProvider.KEY_USER_NAME)
                withContext(Dispatchers.Main) {
                    uiState = uiState.copy(loading = true, userName = userName)
                }
                val newState = try {
                    val result = appServiceUseCase()
                    uiState.copy(appServiceList = result, loading = false)
                } catch (e: Exception) {
                    uiState.copy(
                        errorMessage = "Error loading app service list ${if (!e.localizedMessage.isNullOrEmpty()) " : ${e.localizedMessage}" else ""}",
                        loading = false
                    )
                }
                withContext(Dispatchers.Main) {
                    uiState = newState
                }
            }
        }
    }

    fun getAllSpecializations() {
        val list = specializationDialogState.specializations
        if (list.isNotEmpty()) {
            specializationDialogState = specializationDialogState.copy(
                showDialog = true
            )
        }
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val newState = try {
                    val result = physicianUseCase.getAllSpecializations()
                    specializationDialogState.copy(showDialog = true, specializations = result)
                } catch (e: Exception) {
                    specializationDialogState.copy(
                        showDialog = false, specializations = emptyList()
                    )
                }
                withContext(Dispatchers.Main) {
                    specializationDialogState = newState
                }
            }
        }
    }

    fun dismissSpecializationDialog() {
        specializationDialogState = specializationDialogState.copy(showDialog = false)
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

data class SpecializationDialogState(
    var showDialog: Boolean = false,
    val specializations: List<Specialization> = emptyList(),
)
package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.entity.Physician
import dev.vengateshm.petcareapp.domain.usecase.PhysicianUseCase
import kotlinx.coroutines.launch

class SearchViewModel(private val physicianUseCase: PhysicianUseCase) : ViewModel() {
    val screenState = mutableStateOf(SearchScreenState())

    fun getPhysiciansBySpecializationId(id: Int) {
        viewModelScope.launch {
            screenState.value = screenState.value.copy(
                isLoading = true,
                physicians = emptyList(),
                errorMessage = ""
            )
            try {
                val data = physicianUseCase.getPhysicianBySpecialization(1)
                screenState.value = screenState.value.copy(
                    isLoading = false,
                    physicians = data,
                    errorMessage = ""
                )
            } catch (e: Exception) {
                screenState.value = screenState.value.copy(
                    isLoading = false,
                    physicians = emptyList(),
                    errorMessage = "Error retrieving physicians"
                )
            }
        }
    }
}

data class SearchScreenState(
    val isLoading: Boolean = false,
    val physicians: List<Physician> = emptyList(),
    val errorMessage: String = "",
)
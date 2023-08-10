package dev.vengateshm.petcareapp.android.presentation.screens.pet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.petcareapp.domain.entity.Pet
import dev.vengateshm.petcareapp.domain.usecase.GetMyPetsUseCase
import kotlinx.coroutines.launch

class MyPetsViewModel(private val getMyPetsUseCase: GetMyPetsUseCase) : ViewModel() {

    var uiState by mutableStateOf(MyPetsScreenState())

    init {
        getMyPets()
    }

    private fun getMyPets() {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            uiState = try {
                val result = getMyPetsUseCase()
                uiState.copy(petList = result, loading = false)
            } catch (e: Exception) {
                uiState.copy(
                    errorMessage = "Error loading pet list ${if (!e.localizedMessage.isNullOrEmpty()) " : ${e.localizedMessage}" else ""}",
                    loading = false
                )
            }
        }
    }
}

data class MyPetsScreenState(
    var loading: Boolean = false,
    var petList: List<Pet> = emptyList(),
    var errorMessage: String = "",
)
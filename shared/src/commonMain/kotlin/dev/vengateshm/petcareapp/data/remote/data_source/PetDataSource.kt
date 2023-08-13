package dev.vengateshm.petcareapp.data.remote.data_source

import dev.vengateshm.petcareapp.data.remote.models.PetDto

interface PetDataSource {
    suspend fun getPetsByUser(): List<PetDto>
}
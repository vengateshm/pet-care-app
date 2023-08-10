package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.models.PetDto

interface PetDataSource {
    suspend fun getPetsByUser(): List<PetDto>
}
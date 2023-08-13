package dev.vengateshm.petcareapp.domain.repository

import dev.vengateshm.petcareapp.domain.entity.Pet

interface PetRepository {
    suspend fun getPetsByUser(): List<Pet>
}
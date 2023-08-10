package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.models.mapToPet
import dev.vengateshm.petcareapp.domain.entity.Pet
import dev.vengateshm.petcareapp.domain.repository.PetRepository

class PetRepositoryImpl(private val petDataSource: PetDataSource) : PetRepository {
    override suspend fun getPetsByUser(): List<Pet> {
        return petDataSource.getPetsByUser().map { it.mapToPet() }
    }
}
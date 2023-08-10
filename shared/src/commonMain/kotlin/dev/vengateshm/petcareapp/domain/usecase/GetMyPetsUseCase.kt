package dev.vengateshm.petcareapp.domain.usecase

import dev.vengateshm.petcareapp.domain.entity.Pet
import dev.vengateshm.petcareapp.domain.repository.PetRepository

class GetMyPetsUseCase(private val petRepository: PetRepository) {
    suspend operator fun invoke(): List<Pet> {
        return petRepository.getPetsByUser()
    }
}
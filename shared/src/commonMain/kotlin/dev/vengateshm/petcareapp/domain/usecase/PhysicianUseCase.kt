package dev.vengateshm.petcareapp.domain.usecase

import dev.vengateshm.petcareapp.domain.entity.Physician
import dev.vengateshm.petcareapp.domain.entity.Specialization
import dev.vengateshm.petcareapp.domain.repository.PhysicianRepository

class PhysicianUseCase(private val physicianRepository: PhysicianRepository) {
    suspend fun getAllSpecializations(): List<Specialization> {
        return physicianRepository.getAllSpecializations()
    }

    suspend fun getPhysicianBySpecialization(specializationId: Int): List<Physician> {
        return physicianRepository.getPhysicianBySpecialization(specializationId)
    }
}
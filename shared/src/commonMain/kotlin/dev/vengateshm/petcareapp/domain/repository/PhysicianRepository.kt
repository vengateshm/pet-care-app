package dev.vengateshm.petcareapp.domain.repository

import dev.vengateshm.petcareapp.domain.entity.Physician
import dev.vengateshm.petcareapp.domain.entity.Specialization

interface PhysicianRepository {
    suspend fun getAllSpecializations(): List<Specialization>
    suspend fun getPhysicianBySpecialization(specializationId: Int): List<Physician>
}
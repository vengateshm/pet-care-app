package dev.vengateshm.petcareapp.data.remote.data_source

import dev.vengateshm.petcareapp.data.remote.models.PhysicianDto
import dev.vengateshm.petcareapp.data.remote.models.SpecializationDto

interface PhysicianDataSource {
    suspend fun getAllSpecializations(): List<SpecializationDto>
    suspend fun getPhysicianBySpecialization(specializationId: Int): List<PhysicianDto>
}
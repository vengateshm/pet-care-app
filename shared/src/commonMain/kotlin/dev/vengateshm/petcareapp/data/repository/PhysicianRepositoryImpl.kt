package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.data_source.PhysicianDataSource
import dev.vengateshm.petcareapp.data.remote.models.mapToPhysician
import dev.vengateshm.petcareapp.data.remote.models.mapToSpecialization
import dev.vengateshm.petcareapp.domain.entity.Physician
import dev.vengateshm.petcareapp.domain.entity.Specialization
import dev.vengateshm.petcareapp.domain.repository.PhysicianRepository

class PhysicianRepositoryImpl(private val physicianDataSource: PhysicianDataSource) :
    PhysicianRepository {
    override suspend fun getAllSpecializations(): List<Specialization> {
        return physicianDataSource.getAllSpecializations().map { it.mapToSpecialization() }
    }

    override suspend fun getPhysicianBySpecialization(specializationId: Int): List<Physician> {
        return physicianDataSource.getPhysicianBySpecialization(specializationId)
            .map { it.mapToPhysician() }
    }
}
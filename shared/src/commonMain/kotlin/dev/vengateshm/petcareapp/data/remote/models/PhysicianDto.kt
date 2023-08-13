package dev.vengateshm.petcareapp.data.remote.models

import dev.vengateshm.petcareapp.domain.entity.Physician
import kotlinx.serialization.Serializable

@Serializable
data class PhysicianDto(
    val id: Int? = null,
    val name: String,
    val email: String,
    val phone: String,
    val hospitalId: Int?,
    val specializationId: Int?,
    val hospitalName: String?,
    val specializationName: String?,
)

fun PhysicianDto.mapToPhysician() = Physician(
    id = this.id,
    name = this.name,
    email = this.email,
    phone = this.phone,
    hospitalId = this.hospitalId,
    specializationId = this.specializationId,
    hospitalName = this.hospitalName,
    specializationName = this.specializationName,
)

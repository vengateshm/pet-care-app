package dev.vengateshm.petcareapp.data.remote.models

import dev.vengateshm.petcareapp.domain.entity.Specialization
import kotlinx.serialization.Serializable

@Serializable
data class SpecializationDto(
    val id: Int? = null,
    val name: String,
    val description: String,
)

fun SpecializationDto.mapToSpecialization() = Specialization(
    id = this.id,
    name = this.name,
    description = this.description
)
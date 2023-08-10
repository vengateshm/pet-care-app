package dev.vengateshm.petcareapp.data.remote.models

import dev.vengateshm.petcareapp.domain.entity.Pet
import kotlinx.serialization.Serializable

@Serializable
data class PetDto(
    val id: Int? = null,
    val name: String,
    val gender: String,
    val dob: String,
    val imageUrl: String,
    val userId: Int,
    val speciesTypeId: Int,
    val breedId: Int,
    val speciesTypeName: String? = "",
    val breedName: String? = "",
)

fun PetDto.mapToPet() = Pet(
    id = this.id,
    name = this.name,
    gender = this.gender,
    dob = this.dob,
    imageUrl = this.imageUrl,
    userId = this.userId,
    speciesTypeId = this.speciesTypeId,
    breedId = this.breedId,
    speciesTypeName = this.speciesTypeName,
    breedName = this.breedName,
)

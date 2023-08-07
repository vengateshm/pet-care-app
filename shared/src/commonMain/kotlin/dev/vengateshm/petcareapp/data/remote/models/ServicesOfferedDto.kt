package dev.vengateshm.petcareapp.data.remote.models

import dev.vengateshm.petcareapp.domain.entity.ServicesOffered
import kotlinx.serialization.Serializable

@Serializable
data class ServicesOfferedDto(
    val id: Int,
    val name: String,
    val imgUrl: String,
)

fun ServicesOfferedDto.mapToServicesOffered() = ServicesOffered(
    id = this.id,
    name = this.name,
    imgUrl = this.imgUrl
)
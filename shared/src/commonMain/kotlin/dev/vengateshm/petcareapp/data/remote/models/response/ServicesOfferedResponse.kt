package dev.vengateshm.petcareapp.data.remote.models.response

import dev.vengateshm.petcareapp.data.remote.models.ServicesOfferedDto
import kotlinx.serialization.Serializable

@Serializable
data class ServicesOfferedResponse(
    val data: List<ServicesOfferedDto>,
)
package dev.vengateshm.petcareapp.data.remote.models.response

import dev.vengateshm.petcareapp.data.remote.models.AppServiceDto
import kotlinx.serialization.Serializable

@Serializable
data class AppServiceResponse(
    val data: List<AppServiceDto>,
)
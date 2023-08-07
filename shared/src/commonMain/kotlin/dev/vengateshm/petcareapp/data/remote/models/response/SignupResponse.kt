package dev.vengateshm.petcareapp.data.remote.models.response

import dev.vengateshm.petcareapp.data.remote.models.SignupDto
import kotlinx.serialization.Serializable

@Serializable
data class SignupResponse(
    val data: SignupDto,
)

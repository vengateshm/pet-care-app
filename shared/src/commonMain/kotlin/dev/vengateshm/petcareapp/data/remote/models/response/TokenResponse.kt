package dev.vengateshm.petcareapp.data.remote.models.response

import dev.vengateshm.petcareapp.data.remote.models.UserDto
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    val token: String,
    val user: UserDto,
)
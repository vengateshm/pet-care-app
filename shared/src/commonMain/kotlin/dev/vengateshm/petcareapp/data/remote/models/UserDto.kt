package dev.vengateshm.petcareapp.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int,
    val name: String,
    val email: String,
)

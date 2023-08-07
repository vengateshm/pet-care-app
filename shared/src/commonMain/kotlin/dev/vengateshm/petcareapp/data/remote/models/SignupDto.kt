package dev.vengateshm.petcareapp.data.remote.models

import dev.vengateshm.petcareapp.domain.entity.AppUser
import kotlinx.serialization.Serializable

@Serializable
data class SignupDto(
    val id: Int,
    val name: String,
    val email: String,
)

fun SignupDto.mapToAppUser() = AppUser(
    id = this.id,
    name = this.name,
    email = this.email
)

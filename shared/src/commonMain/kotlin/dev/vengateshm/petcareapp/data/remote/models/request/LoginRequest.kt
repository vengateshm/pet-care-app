package dev.vengateshm.petcareapp.data.remote.models.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val email: String, val password: String)
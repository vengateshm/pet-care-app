package dev.vengateshm.petcareapp.data.remote.models.request

import kotlinx.serialization.Serializable

@Serializable
data class GoogleSignupRequest(val idToken: String)

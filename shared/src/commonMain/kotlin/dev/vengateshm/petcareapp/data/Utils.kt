package dev.vengateshm.petcareapp.data

import dev.vengateshm.petcareapp.data.remote.models.UserDto
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import kotlinx.serialization.json.Json

fun PreferenceProvider.loggedInUserId(): Int {
    val userStr = this.getString(PreferenceProvider.KEY_USER)
    if (userStr.isEmpty()) return -1
    return try {
        val user = Json.decodeFromString<UserDto>(userStr)
        user.id
    } catch (e: Exception) {
        -1
    }
}
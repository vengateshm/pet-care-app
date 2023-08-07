package dev.vengateshm.petcareapp.domain.repository

import dev.vengateshm.petcareapp.domain.entity.AppUser

interface AuthRepository {
    suspend fun login(email: String, password: String): Boolean
    suspend fun signup(name: String, email: String, password: String): AppUser
}
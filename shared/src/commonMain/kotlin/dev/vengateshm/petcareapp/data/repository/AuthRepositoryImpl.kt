package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.models.mapToAppUser
import dev.vengateshm.petcareapp.domain.entity.AppUser
import dev.vengateshm.petcareapp.domain.repository.AuthRepository

class AuthRepositoryImpl(private val authDataSource: AuthDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): Boolean {
        return authDataSource.login(email, password)
    }

    override suspend fun signup(name: String, email: String, password: String): AppUser {
        return authDataSource.signup(name, email, password).mapToAppUser()
    }
}
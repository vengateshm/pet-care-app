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

    override suspend fun signupWithGoogle(idToken: String): AppUser {
        return authDataSource.signupWithGoogle(idToken).mapToAppUser()
    }

    override suspend fun signinWithGoogle(idToken: String): Boolean {
        return authDataSource.signinWithGoogle(idToken)
    }
}
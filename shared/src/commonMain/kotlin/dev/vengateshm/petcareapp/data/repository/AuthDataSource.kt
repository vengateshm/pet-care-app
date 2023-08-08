package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.models.SignupDto

interface AuthDataSource {
    suspend fun login(email: String, password: String): Boolean
    suspend fun signup(name: String, email: String, password: String): SignupDto
    suspend fun signupWithGoogle(idToken: String): SignupDto
    suspend fun signinWithGoogle(idToken: String): Boolean
}
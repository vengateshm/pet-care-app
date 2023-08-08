package dev.vengateshm.petcareapp.domain.usecase

import dev.vengateshm.petcareapp.domain.entity.AppUser
import dev.vengateshm.petcareapp.domain.repository.AuthRepository

class SignupUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(name: String, email: String, password: String): AppUser {
        return authRepository.signup(name, email, password)
    }

    suspend fun signupWithGoogle(idToken: String): AppUser {
        return authRepository.signupWithGoogle(idToken)
    }
}
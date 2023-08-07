package dev.vengateshm.petcareapp.domain.usecase

import dev.vengateshm.petcareapp.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Boolean {
        return authRepository.login(email, password)
    }
}
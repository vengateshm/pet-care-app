package dev.vengateshm.petcareapp.domain.usecase

import dev.vengateshm.petcareapp.domain.entity.AppService
import dev.vengateshm.petcareapp.domain.repository.AppServiceRepository

class AppServiceUseCase(private val appServiceRepository: AppServiceRepository) {
    suspend operator fun invoke(): List<AppService> {
        return appServiceRepository.getAllAppServices()
    }
}
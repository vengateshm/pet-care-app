package dev.vengateshm.petcareapp.domain.usecase

import dev.vengateshm.petcareapp.domain.entity.ServicesOffered
import dev.vengateshm.petcareapp.domain.repository.ServicesOfferedRepository

class ServicesOfferedUseCase(private val servicesOfferedRepository: ServicesOfferedRepository) {
    suspend operator fun invoke(): List<ServicesOffered> {
        return servicesOfferedRepository.getAllServicesOffered()
    }
}
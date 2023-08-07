package dev.vengateshm.petcareapp.domain.repository

import dev.vengateshm.petcareapp.domain.entity.ServicesOffered

interface ServicesOfferedRepository {
    suspend fun getAllServicesOffered(): List<ServicesOffered>
}
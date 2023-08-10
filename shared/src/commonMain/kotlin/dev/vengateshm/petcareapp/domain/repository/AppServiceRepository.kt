package dev.vengateshm.petcareapp.domain.repository

import dev.vengateshm.petcareapp.domain.entity.AppService

interface AppServiceRepository {
    suspend fun getAllAppServices(): List<AppService>
}
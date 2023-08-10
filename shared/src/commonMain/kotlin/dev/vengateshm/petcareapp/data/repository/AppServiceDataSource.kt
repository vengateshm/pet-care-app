package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.models.AppServiceDto

interface AppServiceDataSource {
    suspend fun getAllAppServices(): List<AppServiceDto>
}
package dev.vengateshm.petcareapp.data.remote.data_source

import dev.vengateshm.petcareapp.data.remote.models.AppServiceDto

interface AppServiceDataSource {
    suspend fun getAllAppServices(): List<AppServiceDto>
}
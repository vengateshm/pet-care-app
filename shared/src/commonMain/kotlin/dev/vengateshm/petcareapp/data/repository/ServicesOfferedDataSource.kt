package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.models.ServicesOfferedDto

interface ServicesOfferedDataSource {
    suspend fun getAllServicesOffered(): List<ServicesOfferedDto>
}
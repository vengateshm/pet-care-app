package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.models.mapToServicesOffered
import dev.vengateshm.petcareapp.domain.entity.ServicesOffered
import dev.vengateshm.petcareapp.domain.repository.ServicesOfferedRepository

class ServicesOfferedRepositoryImpl(private val servicesOfferedDataSource: ServicesOfferedDataSource) :
    ServicesOfferedRepository {
    override suspend fun getAllServicesOffered(): List<ServicesOffered> {
        return servicesOfferedDataSource.getAllServicesOffered().map { it.mapToServicesOffered() }
    }
}
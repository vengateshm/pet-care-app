package dev.vengateshm.petcareapp.data.repository

import dev.vengateshm.petcareapp.data.remote.data_source.AppServiceDataSource
import dev.vengateshm.petcareapp.data.remote.models.mapToAppService
import dev.vengateshm.petcareapp.domain.entity.AppService
import dev.vengateshm.petcareapp.domain.repository.AppServiceRepository

class AppServiceRepositoryImpl(private val appServiceDataSource: AppServiceDataSource) :
    AppServiceRepository {
    override suspend fun getAllAppServices(): List<AppService> {
        return appServiceDataSource.getAllAppServices().map { it.mapToAppService() }
    }
}
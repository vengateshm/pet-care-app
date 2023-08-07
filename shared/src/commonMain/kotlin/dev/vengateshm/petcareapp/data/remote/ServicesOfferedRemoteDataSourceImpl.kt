package dev.vengateshm.petcareapp.data.remote

import dev.vengateshm.petcareapp.data.remote.models.ServicesOfferedDto
import dev.vengateshm.petcareapp.data.remote.models.response.ServicesOfferedResponse
import dev.vengateshm.petcareapp.data.repository.ServicesOfferedDataSource
import io.ktor.client.call.body
import io.ktor.client.request.get

class ServicesOfferedRemoteDataSourceImpl(
    private val client: KtorApiClient,
) : ServicesOfferedDataSource {
    override suspend fun getAllServicesOffered(): List<ServicesOfferedDto> {
        val response = client.httpClient.get {
            endPoint("api/v1/pet/services-offered")
        }.body<ServicesOfferedResponse>()
        return response.data
    }
}
package dev.vengateshm.petcareapp.data.remote.data_source

import dev.vengateshm.petcareapp.data.remote.KtorApiClient
import dev.vengateshm.petcareapp.data.remote.endPoint
import dev.vengateshm.petcareapp.data.remote.models.PhysicianDto
import dev.vengateshm.petcareapp.data.remote.models.SpecializationDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class PhysicianRemoteDataSourceImpl(
    private val client: KtorApiClient,
) : PhysicianDataSource {
    override suspend fun getAllSpecializations(): List<SpecializationDto> {
        val response = client.httpClient.get {
            endPoint("api/v1/specializations")
        }.body<HttpResponse>()
        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun getPhysicianBySpecialization(specializationId: Int): List<PhysicianDto> {
        val response = client.httpClient.get {
            endPoint("api/v1/physicians/specialization/$specializationId")
        }.body<HttpResponse>()
        return Json.decodeFromString(response.bodyAsText())
    }
}
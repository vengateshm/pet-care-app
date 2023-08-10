package dev.vengateshm.petcareapp.data.remote

import dev.vengateshm.petcareapp.data.remote.models.AppServiceDto
import dev.vengateshm.petcareapp.data.remote.models.response.AppServiceResponse
import dev.vengateshm.petcareapp.data.repository.AppServiceDataSource
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray

class AppServiceRemoteDataSourceImpl(
    private val client: KtorApiClient,
) : AppServiceDataSource {
    override suspend fun getAllAppServices(): List<AppServiceDto> {
        val response = client.httpClient.get {
            endPoint("api/v1/app-services")
        }.body<HttpResponse>()
        return Json.decodeFromString(response.bodyAsText())
    }
}
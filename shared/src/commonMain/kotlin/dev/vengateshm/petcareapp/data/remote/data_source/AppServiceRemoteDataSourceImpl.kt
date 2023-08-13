package dev.vengateshm.petcareapp.data.remote.data_source

import dev.vengateshm.petcareapp.data.remote.KtorApiClient
import dev.vengateshm.petcareapp.data.remote.endPoint
import dev.vengateshm.petcareapp.data.remote.models.AppServiceDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

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
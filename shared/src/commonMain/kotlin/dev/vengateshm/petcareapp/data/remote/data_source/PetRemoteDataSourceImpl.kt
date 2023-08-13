package dev.vengateshm.petcareapp.data.remote.data_source

import dev.vengateshm.petcareapp.data.loggedInUserId
import dev.vengateshm.petcareapp.data.remote.KtorApiClient
import dev.vengateshm.petcareapp.data.remote.endPoint
import dev.vengateshm.petcareapp.data.remote.models.PetDto
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class PetRemoteDataSourceImpl(
    private val client: KtorApiClient,
    private val preferenceProvider: PreferenceProvider,
) : PetDataSource {
    override suspend fun getPetsByUser(): List<PetDto> {
        val userId = preferenceProvider.loggedInUserId()
        if (userId == -1) return emptyList()
        val response = client.httpClient.get {
            endPoint("api/v1/pets/user/$userId")
        }.body<HttpResponse>()
        return Json.decodeFromString(response.bodyAsText())
    }
}
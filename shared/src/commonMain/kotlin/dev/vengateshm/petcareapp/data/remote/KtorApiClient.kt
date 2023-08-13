package dev.vengateshm.petcareapp.data.remote

import dev.vengateshm.petcareapp.platform.PreferenceProvider
import dev.vengateshm.petcareapp.platform.PreferenceProvider.Companion.KEY_TOKEN
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "http://192.168.247.241:8888/"

class KtorApiClient(private val preferenceProvider: PreferenceProvider) {

    val httpClient by lazy {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                val token = preferenceProvider.getString(KEY_TOKEN)
                if (token.isNotEmpty()) {
                    headers {
                        append("Authorization", "Bearer $token")
                    }
                }
            }
        }
    }
}

fun HttpRequestBuilder.endPoint(path: String) {
    url {
        takeFrom(BASE_URL)
        path(path)
    }
}
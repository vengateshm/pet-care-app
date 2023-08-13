package dev.vengateshm.petcareapp.data.remote.data_source

import dev.vengateshm.petcareapp.data.remote.KtorApiClient
import dev.vengateshm.petcareapp.data.remote.endPoint
import dev.vengateshm.petcareapp.data.remote.models.SignupDto
import dev.vengateshm.petcareapp.data.remote.models.request.GoogleSignupRequest
import dev.vengateshm.petcareapp.data.remote.models.request.LoginRequest
import dev.vengateshm.petcareapp.data.remote.models.request.SignupRequest
import dev.vengateshm.petcareapp.data.remote.models.response.TokenResponse
import dev.vengateshm.petcareapp.platform.PreferenceProvider
import dev.vengateshm.petcareapp.platform.PreferenceProvider.Companion.KEY_TOKEN
import dev.vengateshm.petcareapp.platform.PreferenceProvider.Companion.KEY_USER
import dev.vengateshm.petcareapp.platform.PreferenceProvider.Companion.KEY_USER_NAME
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AuthRemoteDataSourceImpl(
    private val client: KtorApiClient,
    private val preferenceProvider: PreferenceProvider,
) :
    AuthDataSource {
    override suspend fun login(email: String, password: String): Boolean {
        return try {
            val response = client.httpClient.post {
                endPoint("api/v1/auth/login")
                setBody(LoginRequest(email = email, password = password))
            }.body<TokenResponse?>()
            if (response != null && response.token.isNotEmpty()) {
                saveLoginData(response)
                return true
            } else return false
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun signup(name: String, email: String, password: String): SignupDto {
        val response = client.httpClient.post {
            endPoint("api/v1/auth/signup")
            setBody(SignupRequest(name = name, email = email, password = password))
        }.body<SignupDto>()
        return response
    }

    override suspend fun signupWithGoogle(idToken: String): SignupDto {
        val response = client.httpClient.post {
            endPoint("api/v1/auth/signup-google")
            setBody(GoogleSignupRequest(idToken = idToken))
        }.body<SignupDto>()
        return response
    }

    override suspend fun signinWithGoogle(idToken: String): Boolean {
        return try {
            val response = client.httpClient.post {
                endPoint("api/v1/auth/signin-google")
                setBody(GoogleSignupRequest(idToken = idToken))
            }.body<TokenResponse?>()
            if (response != null && response.token.isNotEmpty()) {
                saveLoginData(response)
                return true
            } else return false
        } catch (e: Exception) {
            false
        }
    }

    private fun saveLoginData(response: TokenResponse) {
        preferenceProvider.putString(KEY_TOKEN, response.token)
        if (response.user != null) {
            preferenceProvider.putString(KEY_USER, Json.encodeToString(response.user))
            preferenceProvider.putString(KEY_USER_NAME, response.user.name ?: "")
        }
    }
}
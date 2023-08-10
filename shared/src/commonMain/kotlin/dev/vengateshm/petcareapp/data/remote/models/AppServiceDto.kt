package dev.vengateshm.petcareapp.data.remote.models

import dev.vengateshm.petcareapp.domain.entity.AppService
import kotlinx.serialization.Serializable

@Serializable
data class AppServiceDto(
    val id: Int,
    val name: String,
    val imgUrl: String,
)

fun AppServiceDto.mapToAppService() = AppService(
    id = this.id,
    name = this.name,
    imgUrl = this.imgUrl
)
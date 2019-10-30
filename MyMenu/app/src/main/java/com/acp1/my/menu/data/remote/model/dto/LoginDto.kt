package com.acp1.my.menu.data.remote.model.dto

import com.acp1.my.menu.data.remote.model.ApiResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginDto(
    @Json(name = "data") val data: UserDto,
    @Json(name = "status") override val status: String
) : ApiResponse()
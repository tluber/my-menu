package com.acp1.my.menu.data.remote.model.dto

import com.acp1.my.menu.data.remote.model.ApiResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StandardResponseDto(
    @Json(name = "status") override val status: String,
    @Json(name = "code") override val statusCode: Int?,
    @Json(name = "message") override val statusMessage: String?
) : ApiResponse()
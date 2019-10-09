package com.acp1.my.menu.data.remote.model.dto

import com.acp1.my.menu.data.remote.model.ApiResponse

data class LoginDto(
    val data: UserDto,
    override val status: String,
    override val statusCode: String,
    override val statusMessage: String
) : ApiResponse()

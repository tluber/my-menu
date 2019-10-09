package com.acp1.my.menu.data.mapper

import com.acp1.my.menu.data.local.model.User
import com.acp1.my.menu.data.remote.model.dto.UserDto

fun UserDto.toUser(): User {
    return User(
        id = this.id,
        firstName = this.firstName ?: "",
        lastName = this.lastName,
        email = this.email)
}
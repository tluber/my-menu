package com.acp1.my.menu.data.remote.model

abstract class ApiResponse {
    abstract val status: String
    abstract val statusCode: String
    abstract val statusMessage: String

    fun isSuccessful(): Boolean {
        if (this.status == "successful") {
            return true
        }
        return false
    }
}

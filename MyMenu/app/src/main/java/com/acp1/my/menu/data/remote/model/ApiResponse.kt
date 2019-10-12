package com.acp1.my.menu.data.remote.model

abstract class ApiResponse {
    abstract val status: String
    abstract val statusCode: Int?
    abstract val statusMessage: String?

    fun isSuccessful(): Boolean {
        if (this.status == "success") {
            return true
        }
        return false
    }
}

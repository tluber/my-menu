package com.acp1.my.menu.data.repository

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.Protocol
import okhttp3.Response
import com.acp1.my.menu.data.local.AppPreferences
import com.acp1.my.menu.data.remote.ApiClient
import com.acp1.my.menu.data.remote.model.dto.LoginDto
import com.acp1.my.menu.data.remote.model.dto.StandardResponseDto
import com.acp1.my.menu.data.remote.model.dto.UserDto
import com.acp1.my.menu.data.remote.utils.NetworkHandler
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.presentation.di.base.ApplicationContext
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val services: ApiClient,
    @ApplicationContext val context: Context
) {

    private val defaultScope = CoroutineScope(Dispatchers.Default)

    var user: UserDto? = AppPreferences.user
        private set

    val isLoggedIn: Boolean
        get() = user != null

    private fun updateSession(user: UserDto) {
        AppPreferences.updateSession(user)
        this.user = user
    }

    fun clearSession() {
        AppPreferences.clearSession()
        this.user = null
    }

}
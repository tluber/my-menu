package com.acp1.my.menu.data.repository

import android.content.Context
import com.acp1.my.menu.data.remote.ApiClient
import com.acp1.my.menu.data.remote.model.dto.MenuDto
import com.acp1.my.menu.data.remote.model.dto.PaymentDto
import com.acp1.my.menu.data.remote.utils.NetworkConnectionException
import com.acp1.my.menu.data.remote.utils.NetworkHandler
import com.acp1.my.menu.data.remote.utils.Result
import com.acp1.my.menu.data.remote.utils.awaitResult
import com.acp1.my.menu.presentation.di.base.ApplicationContext
import javax.inject.Inject

class MyMenuRepository @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val services: ApiClient,
    @ApplicationContext val context: Context
) {

    suspend fun getMenu(): Result<MenuDto> {
        return when (networkHandler.isConnected) {
            true -> {
                services.getMenu().awaitResult()
            }
            false, null -> Result.Exception(NetworkConnectionException())
        }
    }

    suspend fun getPayments(): Result<List<PaymentDto>> {
        return when (networkHandler.isConnected) {
            true -> {
                services.getPayments().awaitResult()
            }
            false, null -> Result.Exception(NetworkConnectionException())
        }
    }
}
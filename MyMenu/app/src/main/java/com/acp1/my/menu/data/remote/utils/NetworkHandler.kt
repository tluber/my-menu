package com.acp1.my.menu.data.remote.utils

import android.content.Context
import com.acp1.my.menu.presentation.di.base.ApplicationContext
import com.acp1.my.menu.utils.extensions.networkState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler @Inject constructor(@ApplicationContext private val context: Context) {
    val isConnected get() = context.networkState?.isConnected
}
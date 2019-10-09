package com.acp1.my.menu.utils.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

val Context.networkState: NetworkInfo?
    get() =
        (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
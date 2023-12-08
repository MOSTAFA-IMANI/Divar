package com.mostafa.imani.divar.data.source.network.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


val Context.isNetworkConnected: Boolean
    get() = (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).isCurrentlyConnected()


private fun ConnectivityManager?.isCurrentlyConnected() = when (this) {
    null -> false
    else -> activeNetwork?.let(::getNetworkCapabilities)
        ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
}


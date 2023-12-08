package com.mostafa.imani.divar.data.source.network.util

import android.content.Context
import android.util.Log
import com.mostafa.imani.divar.core.model.error.NetworkException.ApiException
import com.mostafa.imani.divar.core.model.error.NetworkException.UnauthorizedException
import com.mostafa.imani.divar.core.model.error.NetworkException.InternetConnectionException
import com.mostafa.imani.divar.core.model.error.NetworkException.ServerException
import com.mostafa.imani.divar.core.model.error.NetworkException.UnknownException
import retrofit2.HttpException
import retrofit2.Response


suspend fun <R, T : Response<R>> apiCall(
    context: Context,
    block: suspend () -> T,
): R? {
    if (context.isNetworkConnected) {
        Log.d("TAG", "apiCall: 1")
         runCatching {
            Log.d("TAG", "apiCall: 2")

            block()
        }.onSuccess { value ->
            Log.d("TAG", "apiCall: 3$value")
            return value.body()
        }.onFailure { exception ->
            Log.d("TAG", "apiCall: 4$exception")
            if (exception is HttpException) {
                when (exception.code()) {
                    in (500..599) -> {
                        throw ServerException
                    }
                    400,404-> {
                        throw ApiException(exception.code().toString(),exception.message)
                    }

                    401,403 -> {
                        throw UnauthorizedException(exception.code().toString(),exception.message)

                    }
                }
            }

        }
    } else {
        Log.d("TAG", "apiCall: 5")
        throw InternetConnectionException
    }
    Log.d("TAG", "apiCall: 6")
    throw UnknownException
}



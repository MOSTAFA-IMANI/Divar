package com.mostafa.imani.divar.data.source.local.authorization

interface AuthorizationLocalDataSource {
    fun getAuthorizationToken():String
}
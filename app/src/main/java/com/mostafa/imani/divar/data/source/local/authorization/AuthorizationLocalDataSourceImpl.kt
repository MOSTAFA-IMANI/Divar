package com.mostafa.imani.divar.data.source.local.authorization

object AuthorizationLocalDataSourceImpl : AuthorizationLocalDataSource {
    private  const val TOKEN = "fsq3ofdihVYrotVqayPtl6OW+xDHasuNIlHYAynBfi0HAL8="

    override fun getAuthorizationToken(): String {
        return TOKEN
    }
}
package com.mostafa.imani.divar.core.model.error

object NetworkException {
    data class ApiException(val code: String?, val errorMessage: String?) :
        RuntimeException(errorMessage)

    data class UnauthorizedException(val code: String?, val errorMessage: String?) :
        RuntimeException(errorMessage)

    object InternetConnectionException : RuntimeException()
    object ServerException : RuntimeException()
    object UnknownException : RuntimeException()
}
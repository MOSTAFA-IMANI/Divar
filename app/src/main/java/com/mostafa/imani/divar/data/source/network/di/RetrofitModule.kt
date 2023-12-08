package com.mostafa.imani.divar.data.source.network.di

import com.google.gson.Gson
import com.mostafa.imani.divar.data.source.local.authorization.AuthorizationLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.immutableListOf
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient,
        mapper: Converter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.foursquare.com")
            .addConverterFactory(mapper)
            .client(httpClient).build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authorizationLocalDataSource: AuthorizationLocalDataSource,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {

        val httpClient = OkHttpClient.Builder()
            .connectionSpecs(
                immutableListOf(
                    ConnectionSpec.RESTRICTED_TLS,
                    ConnectionSpec.CLEARTEXT
                )
            )
            .addInterceptor(Interceptor { chain ->
                val originalRequest = chain.request()
                val request = chain.request().newBuilder()
                    .addHeader(
                        "Authorization",
                        authorizationLocalDataSource.getAuthorizationToken()
                    ).build()

                try {
                    chain.proceed(request)
                } catch (e: Exception) {
                    chain.proceed(originalRequest)
                }
            })
        httpClient.addInterceptor(httpLoggingInterceptor)

        return httpClient.build()
    }

    @Provides
    fun provideConverterFactory():Converter.Factory{
        return GsonConverterFactory.create()
    }
    @Provides
    fun provideLoggerInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.apply {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        return interceptor
    }

}
package com.mostafa.imani.divar.data.source.network.di

import com.mostafa.imani.divar.data.source.network.api.PlaceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providePlaceApi(retrofit: Retrofit): PlaceApi =
        retrofit.create(PlaceApi::class.java)

}
package com.mostafa.imani.divar.data.source.network.di

import com.mostafa.imani.divar.data.source.network.place.PlaceNetworkDataSource
import com.mostafa.imani.divar.data.source.network.place.PlaceNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindAuthenticator(authenticatorImp: PlaceNetworkDataSourceImpl): PlaceNetworkDataSource

}
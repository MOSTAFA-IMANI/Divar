package com.mostafa.imani.divar.data.source.local.di

import com.mostafa.imani.divar.data.source.local.authorization.AuthorizationLocalDataSource
import com.mostafa.imani.divar.data.source.local.authorization.AuthorizationLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideAuthorizationLocalDataSource(): AuthorizationLocalDataSourceImpl{
        return AuthorizationLocalDataSourceImpl
    }

}
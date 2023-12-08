package com.mostafa.imani.divar.data.source.local.di

import com.mostafa.imani.divar.data.source.local.authorization.AuthorizationLocalDataSource
import com.mostafa.imani.divar.data.source.local.authorization.AuthorizationLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceBindingModule {
    @Binds
    abstract fun provideAuthorizationLocalDataSource(dataSource: AuthorizationLocalDataSourceImpl):
            AuthorizationLocalDataSource
}
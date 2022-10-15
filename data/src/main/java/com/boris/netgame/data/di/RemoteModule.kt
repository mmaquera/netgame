package com.boris.netgame.data.di

import com.boris.netgame.data.server.ApiDataSource
import com.boris.netgame.data.server.SignUpService
import com.boris.netgame.data.source.AuthenticateDataSource
import com.boris.netgame.data.source.SignUpDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindRemoteDataSource(apiDataSource: ApiDataSource): AuthenticateDataSource

    @Binds
    abstract fun bindSignUpDataSource(signUpService: SignUpService): SignUpDataSource
}
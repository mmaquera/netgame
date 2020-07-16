package com.mmaquera.netgame.di.module

import com.boris.netgame.data.network.NetgameAPIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGsonConvert() = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofitNetgame(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api-rest-netgame.herokuapp.com")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideAPIService(retrofit: Retrofit) = retrofit.create(NetgameAPIService::class.java)

}
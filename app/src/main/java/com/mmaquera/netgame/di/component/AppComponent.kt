package com.mmaquera.netgame.di.component

import android.content.Context
import com.boris.netgame.data.network.NetgameAPIService
import com.mmaquera.netgame.di.module.NetworkModule
import com.mmaquera.netgame.di.subcomponents.LoginComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppSubComponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun netgameAPIService(): NetgameAPIService

    fun loginComponent(): LoginComponent.Factory
}
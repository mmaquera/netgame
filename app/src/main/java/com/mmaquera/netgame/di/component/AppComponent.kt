package com.mmaquera.netgame.di.component

import android.content.Context
import com.mmaquera.netgame.di.module.AppModule
import com.mmaquera.netgame.di.module.NetworkModule
import com.mmaquera.netgame.di.module.ViewModelModule
import com.mmaquera.netgame.di.subcomponents.LoginComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        AppSubComponents::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun loginComponent(): LoginComponent.Factory
}
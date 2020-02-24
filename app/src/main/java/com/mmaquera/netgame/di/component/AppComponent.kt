package com.mmaquera.netgame.di.component

import com.mmaquera.netgame.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent
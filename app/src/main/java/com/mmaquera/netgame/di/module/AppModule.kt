package com.mmaquera.netgame.di.module

import androidx.lifecycle.ViewModelProvider
import com.mmaquera.netgame.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule{

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}
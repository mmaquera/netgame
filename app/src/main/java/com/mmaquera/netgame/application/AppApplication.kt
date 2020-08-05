package com.mmaquera.netgame.application

import android.app.Application
import com.mmaquera.netgame.di.component.AppComponent
import com.mmaquera.netgame.di.component.DaggerAppComponent

open class AppApplication : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}
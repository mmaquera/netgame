package com.mmaquera.netgame.application

import android.app.Application
import com.mmaquera.netgame.di.component.AppComponent

class AppApplication : Application(){

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
    }

    private fun initInjection(){
    }
}
package com.mmaquera.netgame.di.component

import com.mmaquera.netgame.di.subcomponents.LoginComponent
import dagger.Module
import dagger.Subcomponent

@Module(subcomponents = [LoginComponent::class])
interface AppSubComponents
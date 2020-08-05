package com.mmaquera.netgame.di.module

import androidx.lifecycle.ViewModel
import com.mmaquera.netgame.di.annotation.ViewModelKey
import com.mmaquera.netgame.view.login.signin.SignInViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel
}
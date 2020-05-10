package com.mmaquera.netgame.di.subcomponents

import com.mmaquera.netgame.view.login.signin.SignInFragment
import com.mmaquera.netgame.view.login.signup.SignUpFragment
import dagger.Subcomponent

@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(fragment: SignInFragment)
    fun inject(fragment: SignUpFragment)
}
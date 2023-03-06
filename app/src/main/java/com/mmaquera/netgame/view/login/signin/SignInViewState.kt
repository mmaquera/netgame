package com.mmaquera.netgame.view.login.signin

sealed class SignInViewState {
    object ShowLoading : SignInViewState()
    object HideLoading : SignInViewState()
    object Authorization : SignInViewState()
    class Error(val message: String) : SignInViewState()
    object AnotherError : SignInViewState()
}
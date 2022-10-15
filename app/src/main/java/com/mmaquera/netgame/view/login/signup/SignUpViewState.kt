package com.mmaquera.netgame.view.login.signup

sealed class SignUpViewState {
    object ShowLoading : SignUpViewState()
    object HideLoading : SignUpViewState()
    object Success : SignUpViewState()
    class Error(val message: String) : SignUpViewState()
}
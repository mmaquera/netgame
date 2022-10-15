package com.mmaquera.netgame.view.login.signin

sealed class SignInEvent {
    class DoLogin(val userName: String, val password: String) : SignInEvent()
}
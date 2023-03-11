package com.mmaquera.netgame.view.login.signin

sealed class SignInIntent {
    class SignIn(val username: String, val password: String) : SignInIntent()
}
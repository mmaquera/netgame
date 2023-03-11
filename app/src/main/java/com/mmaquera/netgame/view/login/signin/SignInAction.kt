package com.mmaquera.netgame.view.login.signin

sealed class SignInAction {
    class Authenticate(val username: String, val password: String) : SignInAction()
}
package com.mmaquera.netgame.view.login.signup

sealed class SignUpViewEvent {
    class DoSignUp(val userName: String, val password: String, val confirmPassword: String) : SignUpViewEvent()
}
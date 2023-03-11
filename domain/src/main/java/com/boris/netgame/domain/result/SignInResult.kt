package com.boris.netgame.domain.result

sealed class SignInResult  {

    sealed class AuthenticationResult: SignInResult() {
        object Authorization : SignInResult()
        class Denied(val message: String) : AuthenticationResult()
        object AnotherError: SignInResult()
    }
}
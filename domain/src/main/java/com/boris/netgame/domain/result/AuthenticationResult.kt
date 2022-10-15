package com.boris.netgame.domain.result

sealed class AuthenticationResult {
    object Authorization : AuthenticationResult()
    class Denied(val message: String) : AuthenticationResult()
    object AnotherError: AuthenticationResult()
}
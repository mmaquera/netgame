package com.boris.netgame.domain.result

sealed class SignUpResult {
    object SignUpSuccess: SignUpResult()
    class SignUpError(val message: String): SignUpResult()
}
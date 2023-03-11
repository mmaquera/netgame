package com.mmaquera.netgame.view.login.signin

sealed class SignInUiState {
    object Render: SignInUiState()
    object ShowLoading : SignInUiState()
    object Authenticate : SignInUiState()
    object UnAuthorized : SignInUiState()
    class Error(val message: String) : SignInUiState()
}

package com.mmaquera.netgame.view.login.signin

fun SignInIntent.mapToAction(): SignInAction {
    return when (this) {
        is SignInIntent.SignIn -> SignInAction.Authenticate(
            username = username,
            password = password
        )
    }
}
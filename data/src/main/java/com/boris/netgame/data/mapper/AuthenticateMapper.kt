package com.boris.netgame.data.mapper

import com.boris.netgame.domain.Token
import com.boris.netgame.data.model.response.Credentials
import com.boris.netgame.data.model.response.Base

fun Credentials.toToken(): Token {
    return Token(
        tokenAccess = tokenAccess,
        expireIn = expireIn,
        typeUser = typeUser,
        status = status
    )
}
package com.boris.netgame.data.mapper

import com.boris.netgame.domain.Token
import com.boris.netgame.data.model.Credentials
import com.boris.netgame.data.model.Response

fun Response<Credentials>.toToken(): Token {
    return Token(
        tokenAccess = data.tokenAccess,
        expireIn = data.expireIn,
        typeUser = data.typeUser,
        status = data.status
    )
}
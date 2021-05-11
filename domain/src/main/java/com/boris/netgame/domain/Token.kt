package com.boris.netgame.domain

class Token(
    val tokenAccess: String,
    val expireIn: Int,
    val typeUser: Int,
    val status: String
)
package com.boris.netgame.data.model.response

data class Credentials(
    val tokenAccess: String,
    val expireIn: Int,
    val typeUser: Int,
    val status: String
)
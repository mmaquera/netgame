package com.boris.netgame.data.model.request

data class Register(
    val userName: String,
    val password: String,
    val userType: Int = 1
)
package com.boris.netgame.data.source

import com.boris.netgame.domain.Token

interface RemoteDataSource {

    suspend fun authenticate(username: String, password: String) : Token
}
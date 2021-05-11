package com.boris.netgame.data.repository

import com.boris.netgame.data.source.RemoteDataSource
import com.boris.netgame.domain.Token
import javax.inject.Inject

class AuthenticateRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun signIn(userName: String, password: String): Token {
        return remoteDataSource.authenticate(userName, password)
    }
}
package com.boris.netgame.data.server

import com.boris.netgame.data.source.RemoteDataSource
import com.boris.netgame.domain.Token
import com.boris.netgame.data.mapper.toToken
import com.boris.netgame.data.model.Authorize
import javax.inject.Inject

class ApiDataSource @Inject constructor(private val apiService: APIService) : RemoteDataSource {

    override suspend fun authenticate(username: String, password: String): Token {
        return apiService.authorize(Authorize(userName = username,password = password)).toToken()
    }
}
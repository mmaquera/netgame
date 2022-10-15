package com.boris.netgame.data.repository

import com.boris.netgame.data.mapper.toToken
import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.source.AuthenticateDataSource
import com.boris.netgame.domain.Token
import javax.inject.Inject

class AuthenticateRepository @Inject constructor(private val remoteDataSource: AuthenticateDataSource) {

    suspend fun signIn(userName: String, password: String): ResultType<Token> {
        return when(val result = remoteDataSource.authenticate(userName, password)){
            is ResultType.AnotherError -> ResultType.AnotherError(result.e)
            is ResultType.Error -> ResultType.Error(result.error)
            is ResultType.Success -> ResultType.Success(result.data.toToken())
        }
    }
}
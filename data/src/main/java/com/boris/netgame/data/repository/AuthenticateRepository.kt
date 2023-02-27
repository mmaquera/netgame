package com.boris.netgame.data.repository

import com.boris.netgame.data.mapper.toToken
import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.source.AuthenticateDataSource
import com.boris.netgame.domain.Token
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthenticateRepository @Inject constructor(private val remoteDataSource: AuthenticateDataSource) {

    suspend fun signIn(userName: String, password: String): Flow<ResultType<Token>> = flow {
        when (val result = remoteDataSource.authenticate(userName, password)) {
            is ResultType.AnotherError -> emit(ResultType.AnotherError(result.e))
            is ResultType.Error -> emit(ResultType.Error(result.error))
            is ResultType.Success -> emit(ResultType.Success(result.data.toToken()))
        }
        /*return when(val result = remoteDataSource.authenticate(userName, password)) {
            is ResultType.AnotherError -> ResultType.AnotherError(result.e)
            is ResultType.Error -> ResultType.Error(result.error)
            is ResultType.Success -> ResultType.Success(result.data.toToken())
        }*/
    }
}

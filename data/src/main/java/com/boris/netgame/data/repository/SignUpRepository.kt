package com.boris.netgame.data.repository

import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.source.SignUpDataSource
import com.boris.netgame.domain.result.SignUpResult
import javax.inject.Inject

class SignUpRepository @Inject constructor(private val signUpDataSource: SignUpDataSource){

    suspend fun signUp(userName: String, password: String): ResultType<SignUpResult>{
        return when(val result = signUpDataSource.signUp(userName, password)){
            is ResultType.AnotherError -> ResultType.AnotherError(result.e)
            is ResultType.Error -> ResultType.Error(result.error)
            is ResultType.Success -> ResultType.Success(SignUpResult.SignUpSuccess)
        }
    }
}
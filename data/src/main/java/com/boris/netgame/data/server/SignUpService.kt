package com.boris.netgame.data.server

import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.model.request.Register
import com.boris.netgame.data.model.response.Code
import com.boris.netgame.data.source.SignUpDataSource
import javax.inject.Inject

class SignUpService @Inject constructor(private val apiService: ApiService) : SignUpDataSource {

    override suspend fun signUp(userName: String, password: String): ResultType<Unit> {
        return try {
            val result = apiService.signUp(Register(userName = userName,password = password))

            return when(result.statusBody.code){
                Code.SUCCESS -> ResultType.Success(data = result.data)
                Code.ERROR -> ResultType.Error(error = result.statusBody.message)
            }
        }catch (e: Exception) {
            ResultType.AnotherError(e)
        }
    }
}
package com.boris.netgame.data.server

import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.model.request.Authorize
import com.boris.netgame.data.model.response.Code
import com.boris.netgame.data.model.response.Credentials
import com.boris.netgame.data.source.AuthenticateDataSource
import javax.inject.Inject

class ApiDataSource @Inject constructor(private val apiService: ApiService) : AuthenticateDataSource {

    override suspend fun authenticate(username: String, password: String): ResultType<Credentials> {
        return try {
            val result = apiService.authorize(Authorize(userName = username,password = password))

            return when(result.statusBody.code){
                Code.SUCCESS -> ResultType.Success(data = result.data)
                Code.ERROR -> ResultType.Error(error = result.statusBody.message)
            }
        }catch (e: Exception) {
            ResultType.AnotherError(e)
        }
    }
}
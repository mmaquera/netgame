package com.boris.netgame.data.source

import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.model.response.Credentials

interface AuthenticateDataSource {

    suspend fun authenticate(username: String, password: String) : ResultType<Credentials>
}
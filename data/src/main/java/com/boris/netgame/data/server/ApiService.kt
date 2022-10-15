package com.boris.netgame.data.server

import com.boris.netgame.data.model.request.Authorize
import com.boris.netgame.data.model.request.Register
import com.boris.netgame.data.model.response.Base
import com.boris.netgame.data.model.response.Credentials
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService{

    @POST("/api/v1/authorize")
    suspend fun authorize(@Body authorize: Authorize): Base<Credentials>

    @POST("/api/v1/user/create")
    suspend fun signUp(@Body register: Register): Base<Unit>
}
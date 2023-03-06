package com.boris.netgame.data.server

import com.boris.netgame.data.model.Authorize
import com.boris.netgame.data.model.Response
import com.boris.netgame.data.model.Credentials
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService{

    @POST("/api/v1/authorize")
    suspend fun authorize(@Body authorize: Authorize): Response<Credentials>
}
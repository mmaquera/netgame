package com.boris.netgame.data.server

import com.boris.netgame.data.model.Response
import com.boris.netgame.data.model.request.Authorize
import com.boris.netgame.data.model.response.Credentials
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/api/v1/authorize")
    suspend fun authorize(@Body authorize: Authorize): Response<Credentials>


    //suspend fun signUp(): Response<>

}
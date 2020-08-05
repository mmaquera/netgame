package com.mmaquera.netgame.data.source

import com.mmaquera.netgame.data.model.Authorize
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService{

    @POST
    suspend fun authorize(@Body authorize: Authorize)
}
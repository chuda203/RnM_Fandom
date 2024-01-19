package com.up45.rnmfandom

import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): ApiResponse
}

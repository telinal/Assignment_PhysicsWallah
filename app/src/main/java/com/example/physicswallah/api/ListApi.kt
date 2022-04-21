package com.example.physicswallah.api

import com.example.physicswallah.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ListApi {
    @GET("/easygautam/data/users")
    suspend fun getUserDetails() : Response<List<Users>>
}
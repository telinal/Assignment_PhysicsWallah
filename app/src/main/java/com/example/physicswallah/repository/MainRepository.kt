package com.example.physicswallah.repository

import com.example.physicswallah.api.ListApi
import com.example.physicswallah.model.Users
import retrofit2.Response

class MainRepository(val listApi: ListApi) {
    suspend fun getUserDetails() : Response<List<Users>> = listApi.getUserDetails()
}
package com.example.physicswallah.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofithelper {

    const val BASE_URL = "https://my-json-server.typicode.com/"
    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getListApi(): ListApi {
        return getInstance().create(ListApi::class.java)
    }
}
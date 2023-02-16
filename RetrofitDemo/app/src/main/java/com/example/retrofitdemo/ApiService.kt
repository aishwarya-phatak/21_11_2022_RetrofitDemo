package com.example.retrofitdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("users?")
    suspend fun getUsers(
            @Query("page") pageNumber : Int
    ):UsersResponseModel

    companion object{
        var apiService : ApiService? = null

        fun getInstance() : ApiService{

            var retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiService = retrofit.create(ApiService::class.java)
            return apiService!!
        }
    }
}
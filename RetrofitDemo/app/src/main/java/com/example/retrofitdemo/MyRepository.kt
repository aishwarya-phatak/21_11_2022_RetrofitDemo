package com.example.retrofitdemo

import com.example.retrofitdemo.UsersResponseModel
import com.example.retrofitdemo.ApiService

class MyRepository (private val apiService: ApiService){
    suspend fun getUsers(pageNumber : Int) : UsersResponseModel{
        return  apiService.getUsers(pageNumber)
    }
}
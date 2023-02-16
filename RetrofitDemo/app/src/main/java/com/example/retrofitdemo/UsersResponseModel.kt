package com.example.retrofitdemo

import com.google.gson.annotations.SerializedName

data class UsersResponseModel (
    @SerializedName("page")
    var page : Int,
    @SerializedName("total_pages")
    var totalPages : Int,
    @SerializedName("data")
    var users : ArrayList<User>
        ){
    override fun toString(): String {
        return page.toString()
    }
}
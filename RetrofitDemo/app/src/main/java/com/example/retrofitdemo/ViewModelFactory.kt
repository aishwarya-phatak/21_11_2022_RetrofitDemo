package com.example.retrofitdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.MyRepository


class ViewModelFactory(val myRepository: MyRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(myRepository) as T
        }
        throw UnknownError()
    }
}
package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModels()
        initObservers()

        binding.btnGetUsers.setOnClickListener {
            userViewModel.getUserByPage()
            it.isEnabled = false
        }
    }

    private fun initObservers(){
        userViewModel.isProcessingLiveData.observe(
            this
        ){
            if(!it){
                binding.btnGetUsers.isEnabled = true
            }
        }
    }

    private fun initViewModels(){
            userViewModel = ViewModelProvider(
                this,
                ViewModelFactory(
                    MyRepository(
                        ApiService.getInstance())
                )
            ).get(UserViewModel::class.java)

        Log.e("tag","response : "+ userViewModel.toString())
    }
}
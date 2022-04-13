package com.example.retrofitexample.domain

import com.example.retrofitexample.network.Controller

class MainRepository constructor(private val retrofitService: Controller){
    fun getAllFish() = retrofitService.getApi().getData()
}
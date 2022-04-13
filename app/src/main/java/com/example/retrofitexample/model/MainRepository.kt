package com.example.retrofitexample.model

import com.example.retrofitexample.network.Controller

class MainRepository constructor(private val retrofitService: Controller){
   fun getAllFish() = retrofitService.getApi().getData()
}
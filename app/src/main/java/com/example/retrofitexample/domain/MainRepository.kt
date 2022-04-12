package com.example.retrofitexample.domain

class MainRepository constructor(private val retrofitService: Controller){
    fun getAllFish() = retrofitService.getApi().getData()
}
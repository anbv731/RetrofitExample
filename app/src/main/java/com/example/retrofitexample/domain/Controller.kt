package com.example.retrofitexample.domain

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class Controller {
    private val BASE_URL = "https://www.fishwatch.gov/api/"
    fun getApi(): FishService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val retrofitController = retrofit.create(FishService::class.java)
        return retrofitController
    }

}


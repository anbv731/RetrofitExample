package com.example.retrofitexample.network

import com.example.retrofitexample.model.FishModel
import retrofit2.http.GET

interface FishService {
    @GET("species")
    suspend fun getData(): List<FishModel>
}

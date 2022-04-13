package com.example.retrofitexample.network

import com.example.retrofitexample.model.FishModel
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface FishService {
    @GET("species")
 // fun getData(): Call<List<FishModel?>>
   fun getData(): Deferred<List<FishModel>>
}

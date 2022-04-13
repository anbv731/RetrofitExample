package com.example.retrofitexample.model

import com.example.retrofitexample.model.FishModel

interface FishRepository {
    suspend fun getFish():List<FishModel>
    //fun getAllFish(): Call<List<FishModel?>>
    fun saveToFavourites(fish: FishModel)
    fun isSavedInFavourites(fish: FishModel): Boolean
}
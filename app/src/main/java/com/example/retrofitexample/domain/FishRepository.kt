package com.example.retrofitexample.domain

interface FishRepository {
    suspend fun getFish():List<FishModel>
    fun saveToFavourites(fish: FishModel)
    fun isSavedInFavourites(fish: FishModel): Boolean
}
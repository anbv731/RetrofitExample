package com.example.retrofitexample.model

import android.content.Context
import com.example.retrofitexample.network.Controller
import com.example.retrofitexample.network.FishService

class FishRepositoryImpl(context: Context) :
    FishRepository {
    private val sharedPreferences =
        context.getSharedPreferences("favourites_names", Context.MODE_PRIVATE)




    override suspend fun getFish(): List<FishModel> {
        return Controller().getApi().getData().await()
        }

    override fun saveToFavourites(fish: FishModel) {
        if (isSavedInFavourites(fish)) {
            deleteFromFavourites(fish)
        } else {
            addToFavourites(fish)
        }
    }

    override fun isSavedInFavourites(fish: FishModel): Boolean {
        return sharedPreferences.getBoolean(fish.speciesName, false)
    }

    private fun deleteFromFavourites(fish: FishModel) {
        sharedPreferences.edit().remove(fish.speciesName).apply()
    }

    private fun addToFavourites(fish: FishModel) {
        sharedPreferences.edit().putBoolean(fish.speciesName, true).apply()
    }
}
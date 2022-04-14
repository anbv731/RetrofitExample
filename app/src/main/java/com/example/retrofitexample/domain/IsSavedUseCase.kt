package com.example.retrofitexample.domain

import com.example.retrofitexample.model.FishModel
import com.example.retrofitexample.model.FishRepository

class IsSavedUseCase(private val repository: FishRepository) {
    fun execute(fish: FishModel):Boolean{
        return repository.isSavedInFavourites(fish)
    }
}
package com.example.retrofitexample.domain

import com.example.retrofitexample.model.FishModel
import com.example.retrofitexample.model.FishRepository

class SaveUseCase (private val repository: FishRepository){
    fun execute(fish: FishModel){
        repository.saveToFavourites(fish)
    }
}

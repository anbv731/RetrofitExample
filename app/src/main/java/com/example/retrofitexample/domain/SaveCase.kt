package com.example.retrofitexample.domain

class SaveCase (private val repository: FishRepository){
    fun execute(fish: FishModel){
        repository.saveToFavourites(fish)
    }
}

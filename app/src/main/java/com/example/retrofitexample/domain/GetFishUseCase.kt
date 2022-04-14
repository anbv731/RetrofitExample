package com.example.retrofitexample.domain

import com.example.retrofitexample.model.FishModel
import com.example.retrofitexample.model.FishRepository

class GetFishUseCase(private val repository: FishRepository) {

    suspend fun execute(): List<FishModel> {
        return repository.getFish()
    }
}
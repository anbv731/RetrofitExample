package com.example.retrofitexample.domain

class GetFishUseCase(private val repository: FishRepository) {

    suspend fun execute(): List<FishModel> {
        return repository.getFish()
    }
}
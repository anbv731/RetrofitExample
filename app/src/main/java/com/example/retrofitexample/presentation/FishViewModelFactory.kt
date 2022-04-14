package com.example.retrofitexample.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexample.domain.GetFishUseCase
import com.example.retrofitexample.domain.IsSavedUseCase
import com.example.retrofitexample.domain.SaveUseCase
import com.example.retrofitexample.model.FishRepositoryImpl


class FishViewModelFactory constructor(
    context: Context,
) : ViewModelProvider.Factory {
    private val fishRepository = FishRepositoryImpl(context)
    private val getFishUseCase = GetFishUseCase(fishRepository)
    private val saveToFavoritesUseCase = SaveUseCase(fishRepository)
    private val isSaveUseCase = IsSavedUseCase(fishRepository)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FishViewModel::class.java)) {
            FishViewModel(
                getFishUseCase,
                saveToFavoritesUseCase,
                isSaveUseCase
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}


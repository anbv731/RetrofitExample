package com.example.retrofitexample.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.domain.GetFishUseCase
import com.example.retrofitexample.domain.IsSavedUseCase
import com.example.retrofitexample.domain.SaveUseCase
import com.example.retrofitexample.model.FishModel
import kotlinx.coroutines.launch

class FishViewModel constructor(
    private val getFishUseCase: GetFishUseCase,
    private val saveToFavoritesUseCase: SaveUseCase,
    private val isFavoritesUseCase: IsSavedUseCase
) : ViewModel() {
    val fishList = MutableLiveData<List<FishModel?>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllFish() {
        viewModelScope.launch {
            try {
                fishList.postValue(getFishUseCase.execute())

            } catch (e: Exception) {
                errorMessage.postValue(e.toString())
            }
        }
    }

    fun saveToFavourite(fish: FishModel) {
        saveToFavoritesUseCase.execute(fish)
    }

    fun isSavedInFavourite(fish: FishModel): Boolean {
        return isFavoritesUseCase.execute(fish)
    }
}

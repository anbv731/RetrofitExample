package com.example.retrofitexample.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.domain.GetFishUseCase
import com.example.retrofitexample.domain.IsSavedUseCase
import com.example.retrofitexample.domain.SaveUseCase
import com.example.retrofitexample.model.FishModel
import com.example.retrofitexample.model.FishRepositoryImpl
import com.example.retrofitexample.model.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(
    private val repository: FishRepositoryImpl,
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
        fun saveToFavourite(fish: FishModel){
            saveToFavoritesUseCase.execute(fish)
        }
        fun isSavedInFavourite(fish:FishModel):Boolean{
            return isFavoritesUseCase.execute(fish)
        }


//        response.enqueue(object : Callback<List<FishModel?>> {
//
//            override fun onResponse(call: Call<List<FishModel?>>, response: Response<List<FishModel?>>) {
//                fishList.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<List<FishModel?>>, t: Throwable) {
//                errorMessage.postValue(t.message)
//            }
//        })
    }
}
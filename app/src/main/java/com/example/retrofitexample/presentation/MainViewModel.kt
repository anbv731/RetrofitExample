package com.example.retrofitexample.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.domain.MainRepository
import com.example.retrofitexample.domain.FishModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {
    val fishList=MutableLiveData<List<FishModel?>>()
    val errorMessage = MutableLiveData<String>()
    fun getAllFish(){
        val response=repository.getAllFish()
        response.enqueue(object : Callback<List<FishModel?>> {

            override fun onResponse(call: Call<List<FishModel?>>, response: Response<List<FishModel?>>) {
                fishList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<FishModel?>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}
package com.example.physicswallah.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.physicswallah.api.Retrofithelper
import com.example.physicswallah.model.Users
import com.example.physicswallah.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val userList = MutableLiveData<List<Users>>()
    val errorMessage = MutableLiveData<String>()

    init {
        getUserDetails()
    }

     fun getUserDetails() {
         viewModelScope.launch(Dispatchers.IO) {
             try {
                 val response = repository.getUserDetails()
                 if (response.isSuccessful){
                     Log.d("telina", "getUserDetails: ${response.body()}")
                     userList.postValue(response.body())
                 } else {
                     errorMessage.postValue("Error")
                 }
             } catch (e: Exception){
                 errorMessage.postValue(e.message)
             }
         }


    }

}
package com.isaigokul.mvvmkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.isaigokul.mvvmkotlin.base.repository.BaseRepository
import com.isaigokul.mvvmkotlin.base.repository.BaseViewModel
import com.isaigokul.mvvmkotlin.base.remote.data.FakeDataItem
import com.isaigokul.mvvmkotlin.base.db.database.AppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SimpleViewModel(private val repository: BaseRepository) : BaseViewModel() {
    val response: MutableLiveData<Any> = MutableLiveData()
    fun check() {
        viewModelScope.launch(Dispatchers.IO) {
            response.postValue(AppDataBase.instance?.sampleDao()?.getAllTasksList())
        }
    }

    fun doApiCall() {
        viewModelScope.launch {
            try {
                showProgress()
                val response = repository.doApiCall("5")
                if (response.isSuccessful) {
                    Log.d("getAllUsers", Gson().toJson(response.body() as List<FakeDataItem?>?))
                }
            } catch (e: Exception) {
                Log.d("getAllUsers", "e")
            }
        }
    }
}
package com.isaigokul.mvvmkotlin.base.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class BaseViewModel() :ViewModel(){
    val progressLive:MutableLiveData<Boolean> = MutableLiveData()
    fun showProgress(){
        progressLive.postValue(true)
    }
    fun hideProgress(){
        progressLive.postValue(false)
    }
}

package com.isaigokul.mvvmkotlin.base.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class Factory(private val repos: BaseRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(BaseRepository::class.java).newInstance(repos)
    }

    fun <T: ViewModel> createFactory(): ViewModelProvider.Factory {
        val viewModel = this
        return object: ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T: ViewModel> create(modelClass: Class<T>): T = viewModel as T
        }
    }
}
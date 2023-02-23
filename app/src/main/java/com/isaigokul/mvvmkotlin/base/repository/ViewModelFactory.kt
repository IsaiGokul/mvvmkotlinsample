package com.isaigokul.mvvmkotlin.base.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ViewModelFactory {
    fun <T: ViewModel> T.createFactory(vararg params: Class<*>): ViewModelProvider.Factory {
        val viewModel = this
        return object: ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T: ViewModel> create(modelClass: Class<T>): T = viewModel as T
        }
    }
}
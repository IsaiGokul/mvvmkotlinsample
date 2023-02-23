package com.isaigokul.mvvmkotlin.base.repository

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding, VM : ViewModel>(
    private val repository: BaseRepository,
    private val viewModelClass: Class<VM>
) : AppCompatActivity() {
    lateinit var viewBinding: VB

    lateinit var viewModel: VM
    lateinit var baseRepository: BaseRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, resLayout())
        viewModel = ViewModelProvider(this, Factory(repository))[viewModelClass]
        setContentView(viewBinding.root)
        viewModelObserver(viewModel as BaseViewModel)
        observer()
        init()
    }

    abstract fun init()
    abstract fun resLayout(): Int
    abstract fun observer()

    private fun viewModelObserver(viewModel: BaseViewModel) {
        viewModel.progressLive.observe(this) {
            Log.v("progressLive", "loaded")
        }
    }
}
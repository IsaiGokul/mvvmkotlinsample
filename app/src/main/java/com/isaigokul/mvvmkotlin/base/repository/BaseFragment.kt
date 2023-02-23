package com.isaigokul.mvvmkotlin.base.repository

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    private val repository: BaseRepository,
    private val viewModelClass: Class<VM>
) : Fragment() {
    lateinit var viewBinding: VB

    lateinit var viewModel: VM
    lateinit var baseRepository: BaseRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, Factory(repository))[viewModelClass]
        viewModelObserver(viewModel as BaseViewModel)
        observer()
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =  DataBindingUtil.inflate(inflater, resLayout(), container, false)
        return viewBinding.root
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
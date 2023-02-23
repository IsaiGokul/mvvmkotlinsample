package com.isaigokul.mvvmkotlin

import com.isaigokul.mvvmkotlin.base.repository.BaseFragment
import com.isaigokul.mvvmkotlin.base.repository.RepoInstance
import com.isaigokul.mvvmkotlin.databinding.FragmentSampleBinding


class SimpleFragment: BaseFragment<FragmentSampleBinding, SimpleViewModel>(
    RepoInstance.getInstance(),
    SimpleViewModel::class.java) {
    override fun init() {
        viewModel.check()
        viewModel.doApiCall()
    }

    override fun resLayout(): Int = R.layout.fragment_sample

    override fun observer() {

    }
}
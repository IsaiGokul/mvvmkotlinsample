package com.isaigokul.mvvmkotlin

import android.util.Log
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.isaigokul.mvvmkotlin.base.repository.BaseActivity
import com.isaigokul.mvvmkotlin.base.repository.RepoInstance
import com.isaigokul.mvvmkotlin.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, SimpleViewModel>(
    RepoInstance.getInstance(),
    SimpleViewModel::class.java
) {

    override fun init() {

        // val viewModel = ViewModelProvider(this,VieMoF)[SimpleViewModel::class.java]
        viewBinding.frameLayout
        addFragment(SimpleFragment(), false)

    }

    override fun resLayout(): Int {
        return R.layout.activity_main
    }

    override fun observer() {
        viewModel.response.observe(this) {
            Log.d("AppDataBase", Gson().toJson(it))
        }
    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(viewBinding.frameLayout.id, fragment)
        when {
            addToBackStack -> {
                transaction.addToBackStack(fragment.javaClass.name)
            }
        }
        transaction.commit()
    }

}
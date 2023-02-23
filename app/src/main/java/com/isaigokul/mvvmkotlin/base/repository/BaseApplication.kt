package com.isaigokul.mvvmkotlin.base.repository

import android.app.Application
import com.isaigokul.mvvmkotlin.base.db.database.AppDataBase

class BaseApplication:Application (){
    override fun onCreate() {
        super.onCreate()
        AppDataBase.getDataBaseClient(this,"SampleDatabase")
    }
}
package com.isaigokul.mvvmkotlin.base.repository

import com.isaigokul.mvvmkotlin.base.data.apihelper.ApiInterface
import com.isaigokul.mvvmkotlin.base.db.database.AppDataBase

class BaseRepository(val appDataBase: AppDataBase, val networkService: ApiInterface) {

    suspend fun doApiCall(limit:String)=networkService.getAllUsers(limit)


}
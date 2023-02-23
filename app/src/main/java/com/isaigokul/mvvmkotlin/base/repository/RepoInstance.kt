package com.isaigokul.mvvmkotlin.base.repository

import com.isaigokul.mvvmkotlin.base.data.apihelper.ApiInterface
import com.isaigokul.mvvmkotlin.base.data.apihelper.RetroFitHelper
import com.isaigokul.mvvmkotlin.base.db.database.AppDataBase

class RepoInstance {
    companion object{
        @Volatile
        private var INSTANCE: BaseRepository? = null
        lateinit var  networkService: ApiInterface
        lateinit var database: AppDataBase
        fun getInstance(): BaseRepository {
                if (INSTANCE == null) {
                    synchronized(this) {
                        networkService =
                            RetroFitHelper.create("https://fakestoreapi.com", ApiInterface::class.java)
                        database = AppDataBase.instance!!
                        INSTANCE = BaseRepository(database, networkService)
                    }
                }
                return INSTANCE as BaseRepository
            }
    }
}
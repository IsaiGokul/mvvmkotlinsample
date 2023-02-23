package com.isaigokul.mvvmkotlin.base.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.isaigokul.mvvmkotlin.base.db.dao.SampleDao
import com.isaigokul.mvvmkotlin.base.db.entity.SampleEntity

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun sampleDao(): SampleDao

    companion object {
        @Volatile
        var instance: AppDataBase?=null
        fun getDataBaseClient(context: Context,name:String): AppDataBase {
            if (instance != null) return instance as AppDataBase
            synchronized(this) {
                instance = Room
                    .databaseBuilder(context, AppDataBase::class.java, name)
                    .allowMainThreadQueries()
                    .build()
                return instance as AppDataBase
            }
        }
    }
}
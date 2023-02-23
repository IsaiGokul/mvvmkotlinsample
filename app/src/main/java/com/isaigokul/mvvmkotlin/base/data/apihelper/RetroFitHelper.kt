package com.isaigokul.mvvmkotlin.base.data.apihelper

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    val gson = GsonBuilder()
        .setLenient()
        .create()

    fun getInstance(url: String): Retrofit {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(mOkHttpClient)
            .build()
    }

    fun <T : Any> create(url: String, interactor: Class<T>): T {
        return getInstance(url).create(interactor)
    }


    fun <R> Response<ResponseBody>.cast(classType: Class<R>): R? {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val body = this.body()?.string() ?: return null
        return gson.fromJson<R>(body, classType)
    }
}
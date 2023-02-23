package com.isaigokul.mvvmkotlin.base.data.apihelper

import com.isaigokul.mvvmkotlin.base.remote.data.FakeDataItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("Accept: application/json")
    @GET("products")
    suspend fun getAllUsers(@Query("limit") limit:String): Response< List<FakeDataItem?>?>
}
package com.example.androidperformanceoptimization

import com.example.example.Categoriespojo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface BackendApi {

  //@GET("/quotes")
   // @Headers("user-key: dac11f22c358c06a8d66f10255ea1dd2")
    @GET("categories")
    suspend fun getcategories(): Response<Categoriespojo>
}
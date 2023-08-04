package com.example.androidperformanceoptimization.data.network

import com.example.androidperformanceoptimization.model.Categoriespojo
import retrofit2.Response
import retrofit2.http.GET

public interface BackendApi {

  //@GET("/quotes")
   // @Headers("user-key: dac11f22c358c06a8d66f10255ea1dd2")
    @GET("countries/currency/")
    suspend fun getcategories(): Response<Categoriespojo>
}
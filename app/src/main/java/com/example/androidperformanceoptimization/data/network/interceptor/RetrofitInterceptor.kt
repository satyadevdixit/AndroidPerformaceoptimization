package com.example.androidperformanceoptimization.data.network.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RetrofitInterceptor @Inject constructor() :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request().newBuilder()
        request.addHeader("user-key","dac11f22c358c06a8d66f10255ea1dd2")
       return chain.proceed(request.build())
    }
}
package com.example.androidperformanceoptimization

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofirConfiguration @Inject constructor(){

    @Singleton
    @Provides
    fun provideokttp(retrofitInterceptor: RetrofitInterceptor):OkHttpClient
    {
        return OkHttpClient.Builder().addInterceptor(retrofitInterceptor).build()
    }

        @Singleton
        @Provides
        fun provideretrofitobject(okHttpClient: OkHttpClient): Retrofit {

            return Retrofit.Builder().baseUrl("https://developers.zomato.com/api/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()
        }

    @Singleton
    @Provides
    fun getCategoryapi(retrofit: Retrofit):BackendApi{
        return retrofit.create(BackendApi::class.java)
    }


}
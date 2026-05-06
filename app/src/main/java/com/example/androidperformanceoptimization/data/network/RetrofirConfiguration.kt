package com.example.androidperformanceoptimization.data.network

import android.content.Context
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.data.network.interceptor.RetrofitInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitConfiguration {

@Singleton
    @Provides
    fun provideOkHttp(retrofitInterceptor: RetrofitInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(retrofitInterceptor)
            .build()
    }

@Singleton
        @Provides
        fun provideRetrofitObject(
            okHttpClient: OkHttpClient,
            @ApplicationContext context: Context
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(context.resources.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }


@Singleton
    @Provides
    fun getCategoryApi(retrofit: Retrofit): BackendApi {
        return retrofit.create(BackendApi::class.java)
    }


}
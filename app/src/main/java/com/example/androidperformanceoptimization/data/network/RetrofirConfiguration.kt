package com.example.androidperformanceoptimization.data.network

import android.content.Context
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.data.network.interceptor.RetrofitInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
        fun provideretrofitobject(okHttpClient: OkHttpClient,@ApplicationContext context: Context): Retrofit {

            return Retrofit.Builder().baseUrl(context.resources.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
               .client(okHttpClient)
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()
        }

@Singleton
    @Provides
    fun getCategoryapi(retrofit: Retrofit): BackendApi {
        return retrofit.create(BackendApi::class.java)
    }


}
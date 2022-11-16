package com.example.androidperformanceoptimization

import android.app.Application
import android.content.res.Configuration
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Log.e("AppApplication","onCreate")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e("AppApplication","onConfigurationChanged")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.e("AppApplication","onLowMemory")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.e("AppApplication","onTerminate")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.e("onTrimMemory","onTrimMemory")
    }


}
package com.example.androidperformanceoptimization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onPause() {
        super.onPause()
        Log.e("DetailActivity","onPause")
    }

    override fun onStart() {
        super.onStart()
        Log.e("DetailActivity","onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.e("DetailActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("DetailActivity","onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.e("DetailActivity","onSaveInstanceState PersistableBundle")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("DetailActivity","onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("DetailActivity","onRestoreInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.e("DetailActivity","onRestoreInstanceState PersistableBundle")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.e("DetailActivity","onPostResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("DetailActivity","onRestart")
    }


    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Log.e("DetailActivity","onTopResumedActivityChanged")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.e("DetailActivity","onLowMemory")
    }

    override fun onCreateDescription(): CharSequence? {
        return super.onCreateDescription()
        Log.e("DetailActivity","onCreateDescription")
    }


    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        Log.e("DetailActivity","onPostCreate")
    }

    override fun onContentChanged() {
        super.onContentChanged()
        Log.e("DetailActivity","onContentChanged")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.e("DetailActivity","onTrimMemory")
    }


}
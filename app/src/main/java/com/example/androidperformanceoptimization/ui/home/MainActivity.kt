package com.example.androidperformanceoptimization.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.androidperformanceoptimization.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
     lateinit var categoryViewModel: CategoryViewModel
     /*@Inject
     lateinit var dummy: dummy*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MainActivity","onCreate")
        setContentView(R.layout.activity_main)
        lifecycleScope.launch { categoryViewModel.getCategory().observe(this@MainActivity, Observer { it-> Log.e("MainactivityObser",it.toString())}) }

//        Log.e("Mainactivitydummy",dummy.backendApi.toString())

    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity","onPause")
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity","onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity","onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.e("MainActivity","onSaveInstanceState PersistableBundle")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("MainActivity","onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("MainActivity","onRestoreInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.e("MainActivity","onRestoreInstanceState PersistableBundle")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.e("MainActivity","onPostResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity","onRestart")
    }


    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Log.e("MainActivity","onTopResumedActivityChanged")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.e("MainActivity","onLowMemory")
    }

    override fun onCreateDescription(): CharSequence? {
        return super.onCreateDescription()
        Log.e("MainActivity","onCreateDescription")
    }


    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        Log.e("MainActivity","onPostCreate")
    }

    override fun onContentChanged() {
        super.onContentChanged()
        Log.e("MainActivity","onContentChanged")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.e("MainActivity","onTrimMemory")
    }

}
package com.example.androidperformanceoptimization.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.work.Logger
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.databinding.ActivityLoginActiviyBinding
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlin.math.log

class LoginActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_login_activiy)
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val dataBinding:ActivityLoginActiviyBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_activiy)
        dataBinding.loginviewmodel = loginViewModel

        lifecycleScope.launch { coroutineexample() }
    }

    suspend fun coroutineexample()
    {

        lifecycleScope.launch {
            Log.d("loginactivity", "launch")
        }

        var data = lifecycleScope.async(Dispatchers.Default) {
            Log.d("loginactivity", "async 1")
            delay(3000)
            Log.d("loginactivity", "async 2")
           // Toast.makeText(this,"showing",Toast.LENGTH_SHORT).show()
            4 + 9
        }


        data.cancel()
        Log.d("loginactivity", "async 3")
        Log.d("loginactivity",data.await().toString())

        Log.d("loginactivity", "async 4")
    }
}
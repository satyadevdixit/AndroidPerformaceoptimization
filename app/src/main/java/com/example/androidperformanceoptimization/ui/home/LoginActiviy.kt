package com.example.androidperformanceoptimization.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.databinding.ActivityLoginActiviyBinding
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel

class LoginActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activiy)
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val dataBinding:ActivityLoginActiviyBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_activiy)
        dataBinding.loginviewmodel = loginViewModel
    }
}
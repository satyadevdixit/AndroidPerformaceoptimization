package com.example.androidperformanceoptimization.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.activity.viewModels
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.databinding.ActivityLoginActiviyBinding
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding: ActivityLoginActiviyBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login_activiy)
        dataBinding.loginviewmodel = loginViewModel
        dataBinding.lifecycleOwner = this
    }
}
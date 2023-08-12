package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.ui.home.MainActivity

class LoginViewModel(val context: Application) :AndroidViewModel(context), Observable {

    @Bindable
    val userEmailId = MutableLiveData<String>()

    @Bindable
    val userPassword = MutableLiveData<String>()
    fun signInButtonClick()
    {
         if (validateLoginCredentials(userEmailId.value.toString() ,userPassword.value.toString()))
         {
                val intent = Intent(context,MainActivity::class.java)
             intent.apply { this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
             context.startActivity(intent)
         }
         else
         {
              Toast.makeText(context,"Invalid Credentials OR Please enter Credentials",Toast.LENGTH_SHORT).show()
         }
    }


    fun validateLoginCredentialsEmpty(email:String, password:String):Boolean
    {
        if (email.isEmpty())
            return false
        if (password.isEmpty())
            return false

        return true
    }

    fun validateLoginCredentials(email:String, password:String):Boolean
    {
     if ((email.equals("gmail.com")) && (password.equals("password")))
         return true

        return false
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}
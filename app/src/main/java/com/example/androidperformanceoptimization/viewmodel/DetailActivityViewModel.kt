package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailActivityViewModel @Inject constructor(context: Application) : AndroidViewModel(context) {

   var city = MutableLiveData<String>()
   var country = MutableLiveData<String>()

     fun setData(cityName:String, countryName:String)
    {
        city.value = cityName
        country.value = countryName
    }

    fun validatedata(bundle: Bundle?):Boolean
    {
        return (bundle!=null && bundle.containsKey("countryname") && bundle.containsKey("currency") && bundle.getString("countryname")!=null && bundle.getString("currency")!=null)
    }

}
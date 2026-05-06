package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailActivityViewModel @Inject constructor(context:Application):AndroidViewModel(context) {

   @Inject
   lateinit var categoryRepository: CategoryRepository
   var city = MutableLiveData<String>()
   var country = MutableLiveData<String>()

     fun setData(cityName:String, countryName:String)
    {
        viewModelScope.launch {  }
        city.value = cityName
        country.value = countryName
    }

    fun validatedata(bundle: Bundle?):Boolean
    {
        return (bundle!=null && bundle.containsKey("countryname") && bundle.containsKey("currency") && bundle.getString("countryname")!=null && bundle.getString("currency")!=null)
    }

}
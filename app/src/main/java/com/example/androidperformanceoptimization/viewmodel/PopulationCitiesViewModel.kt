package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.model.PopulationCitiesPojo
import com.example.androidperformanceoptimization.model.PopulationCountDetail
import javax.inject.Inject

class PopulationCitiesViewModel @Inject constructor(context:Application):AndroidViewModel(context) {

   @Inject
   lateinit var categoryRepository: CategoryRepository
   var city = MutableLiveData<String>()
   var country = MutableLiveData<String>()

   suspend fun getPopulationCities():MutableLiveData<PopulationCitiesListPojo>
   {
      if (this::categoryRepository.isInitialized)
      {
         return categoryRepository.getPopulationCitesCount()
         Log.e("CategoryViewModel","Initialized")
      }
      else
      {
         Log.e("CategoryViewModel","not Initialized")
      }

        return MutableLiveData<PopulationCitiesListPojo>()
   }


   fun setData(cityName:String, countryName:String)
   {
      city.value = cityName
      country.value = countryName
   }



}
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
import kotlinx.coroutines.delay
import javax.inject.Inject

class PopulationCitiesViewModel @Inject constructor(context:Application):AndroidViewModel(context) {

   @Inject
   lateinit var categoryRepository: CategoryRepository
   var city = MutableLiveData<String>()
   var country = MutableLiveData<String>()
    var ciyList = MutableLiveData<PopulationCitiesListPojo>()

   suspend fun getPopulationCities(testOrNot:Boolean):MutableLiveData<PopulationCitiesListPojo>
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

      if (testOrNot)
         return createDummyData()

        return MutableLiveData<PopulationCitiesListPojo>()
   }


  suspend fun setData(cityName:String, countryName:String):MutableLiveData<PopulationCitiesListPojo>
   {
      city.value = cityName
      country.value = countryName
        return createDummyData()
   }

 fun createDummyData():MutableLiveData<PopulationCitiesListPojo>
   {
  return ciyList
}

  suspend  fun setCityListData()
    {
        val list = arrayListOf<PopulationCitiesPojo>()
        val populatonData = MutableLiveData<PopulationCitiesListPojo>()
        val populatonData1 = MutableLiveData<PopulationCitiesListPojo>()
        val populationCountDetail = PopulationCountDetail()
        val populationCitiesPojo = PopulationCitiesPojo("palwal","India", arrayListOf())
        list.add(populationCitiesPojo)
        val populationCitiesListPojo = PopulationCitiesListPojo(list)
        ciyList.value = populationCitiesListPojo
    }

}
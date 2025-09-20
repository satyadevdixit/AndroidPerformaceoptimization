package com.example.androidperformanceoptimization.data.network.repo

import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.BackendApi
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import retrofit2.Response
import javax.inject.Inject

class CategoryRepository @Inject constructor(){

    @Inject
    lateinit var backendApi: BackendApi

   suspend fun getcategorydata(): Response<Categoriespojo>
    {
        return  backendApi.getcategories()
    }

    suspend fun getPopulationCitesCount(): Response<PopulationCitiesListPojo>
    {
        return  backendApi.getPopulationCities()
    }
}
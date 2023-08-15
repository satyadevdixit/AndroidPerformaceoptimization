package com.example.androidperformanceoptimization.data.network.repo

import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.BackendApi
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import org.junit.Assert.*

import org.junit.Before
import javax.inject.Inject

class CategoryRepositoryTest @Inject constructor() {
    val categorydata: MutableLiveData<Categoriespojo> = MutableLiveData<Categoriespojo>()
    val populationCitiesListPojo: MutableLiveData<PopulationCitiesListPojo> =
        MutableLiveData<PopulationCitiesListPojo>()
    val populationCitiesListPojo1: MutableLiveData<PopulationCitiesListPojo> =
        MutableLiveData<PopulationCitiesListPojo>()

    @Inject
    lateinit var backendApi: BackendApi

    suspend fun getcategorydata(): MutableLiveData<Categoriespojo> {
        val result = backendApi.getcategories()
        categorydata.postValue(result.body())
        return categorydata
    }

    suspend fun getPopulationCitesCount(): MutableLiveData<PopulationCitiesListPojo> {
        val result = backendApi.getPopulationCities()
        populationCitiesListPojo.value = result.body()
        //  populationCitiesListPojo.postValue(result.body())
        return populationCitiesListPojo
    }
}
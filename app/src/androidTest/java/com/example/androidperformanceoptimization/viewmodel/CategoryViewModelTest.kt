package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.model.PopulationCitiesPojo
import com.example.androidperformanceoptimization.model.PopulationCountDetail
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CategoryViewModelTest(val context: Application) : AndroidViewModel(context) {

    val categorydata:MutableLiveData<Categoriespojo> = MutableLiveData<Categoriespojo>()

    @Mock
   lateinit var categoryRepository:CategoryRepository

     fun getCategory(): MutableLiveData<Categoriespojo>
    {
        if (this::categoryRepository.isInitialized)
        {
            Log.e("CategoryViewModel","Initialized")
        }
        else
        {
            Log.e("CategoryViewModel","not Initialized")
        }
        return categorydata
    }

    suspend  fun setCategoryListData()
    {
        val list = arrayListOf<CategoriesDetailpojo>()
       // val populatonData = MutableLiveData<PopulationCitiesListPojo>()
        //val populatonData1 = MutableLiveData<PopulationCitiesListPojo>()
        //val populationCountDetail = PopulationCountDetail()
        val categoryDetailpojo =  CategoriesDetailpojo()
       // val populationCitiesPojo = PopulationCitiesPojo("palwal","India", arrayListOf())
        list.add(categoryDetailpojo)
        val categoriespojo = Categoriespojo(list)
        categorydata.value = categoriespojo
    }


}
package com.example.androidperformanceoptimization.data.network.repo

import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.BackendApi
import com.example.androidperformanceoptimization.model.Categoriespojo
import javax.inject.Inject

class CategoryRepository @Inject constructor(){

 val categorydata:MutableLiveData<Categoriespojo> = MutableLiveData<Categoriespojo>()
    @Inject
    lateinit var backendApi: BackendApi

   suspend fun getcategorydata():MutableLiveData<Categoriespojo>
    {
        val result = backendApi.getcategories()
         categorydata.postValue(result.body())
      return  categorydata
    }
}
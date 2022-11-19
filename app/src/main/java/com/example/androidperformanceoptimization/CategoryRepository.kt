package com.example.androidperformanceoptimization

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.example.Categoriespojo
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
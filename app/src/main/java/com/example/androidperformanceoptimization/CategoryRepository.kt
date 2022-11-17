package com.example.androidperformanceoptimization

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.example.Categoriespojo
import javax.inject.Inject

class CategoryRepository @Inject constructor(val backendApi: BackendApi){

 val categorydata:MutableLiveData<Categoriespojo> = MutableLiveData<Categoriespojo>()


   suspend fun getcategorydata():MutableLiveData<Categoriespojo>
    {
        val result = backendApi.getcategories()
        result.let { // Checking the results
            Log.e("MainActivityresult", result.body().toString())
        }
         categorydata.postValue(result.body())
      return  categorydata
    }
}
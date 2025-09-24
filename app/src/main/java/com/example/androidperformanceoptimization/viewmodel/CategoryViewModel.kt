package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.Categoriespojo
import okhttp3.Response
import javax.inject.Inject

//@HiltViewModel
public class CategoryViewModel @Inject constructor(context:Application) : AndroidViewModel(context)  {
    @Inject
    lateinit var categoryRepository: CategoryRepository

    val categorydata:MutableLiveData<Categoriespojo> = MutableLiveData<Categoriespojo>()
    val categorydatalive:LiveData<Categoriespojo>
        get() = categorydata

    fun observeCategoryLiveData():MutableLiveData<Categoriespojo>
    {
        return categorydata
    }


    fun setData()
    {
        categorydata.postValue(Categoriespojo())
    }


suspend fun getCategory()
{
    if (this::categoryRepository.isInitialized)
    {
Log.e("CategoryViewModel","Initialized")
    }
    else
    {
        Log.e("CategoryViewModel","not Initialized")
    }

    categorydata.postValue(categoryRepository.getcategorydata().body())
}

    override fun onCleared() {
        super.onCleared()
        Log.e("CategoryViewModel","onCleared" )
    }
}
package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.work.Logger
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.model.Categoriespojo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
public class CategoryViewModel @Inject constructor(context:Application) : AndroidViewModel(context)  {
    @Inject
    lateinit var categoryRepository: CategoryRepository

    val categorydata:MutableLiveData<Categoriespojo> = MutableLiveData<Categoriespojo>()

    fun observeCategoryLiveData():MutableLiveData<Categoriespojo>
    {

        return categorydata
    }


suspend fun getCategory()
{
    if (this::categoryRepository.isInitialized)
    {
        val response = categoryRepository.getcategorydata()
        if (validateData(response))
        {
            categorydata.postValue(response.body())
            launchCoroutine()
        }
    }
}

fun validateData(response: retrofit2.Response<Categoriespojo>):Boolean
{
    return response!=null && response.isSuccessful && response.body()!=null
}

    override fun onCleared() {
        super.onCleared()
        Log.e("CategoryViewModel","onCleared" )
    }

   fun launchCoroutine()
    {
        viewModelScope.launch {
           var  list :ArrayList<CategoriesDetailpojo> = arrayListOf(CategoriesDetailpojo())
            var category = CategoriesDetailpojo()
            category.countryName = "India"
            category.count  = 10
            category.currency = "rupees"
            list.add(category)
Log.d("CategoryViewModellaunch","launchCoroutine" )
//            delay(3000)
           // categorydata.value = Categoriespojo(list)
categorydata.postValue(Categoriespojo(list))
        }
    }
}


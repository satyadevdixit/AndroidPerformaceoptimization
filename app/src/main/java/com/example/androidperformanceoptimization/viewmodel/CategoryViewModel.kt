package com.example.androidperformanceoptimization

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.Categoriespojo
import javax.inject.Inject

//@HiltViewModel
class CategoryViewModel @Inject constructor(context:Application) : AndroidViewModel(context)  {
    @Inject
    lateinit var categoryRepository: CategoryRepository

suspend fun getCategory():MutableLiveData<Categoriespojo>
{
    if (this::categoryRepository.isInitialized)
    {
Log.e("CategoryViewModel","Initialized")
    }
    else
    {
        Log.e("CategoryViewModel","not Initialized")
    }
return categoryRepository.getcategorydata()
}

    override fun onCleared() {
        super.onCleared()

        Log.e("CategoryViewModel","onCleared" )
    }
}
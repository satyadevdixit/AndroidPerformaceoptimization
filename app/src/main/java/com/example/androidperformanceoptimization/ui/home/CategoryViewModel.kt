package com.example.androidperformanceoptimization.ui.home

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
return categoryRepository.getcategorydata()
}

    override fun onCleared() {
        super.onCleared()

        Log.e("CategoryViewModel","onCleared" )
    }
}
package com.example.androidperformanceoptimization

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Categoriespojo
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
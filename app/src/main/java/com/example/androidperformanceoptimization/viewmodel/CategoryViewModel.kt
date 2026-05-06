package com.example.androidperformanceoptimization.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.Categoriespojo
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    context: Application,
    private val categoryRepository: CategoryRepository
) : AndroidViewModel(context) {

    val categorydata: MutableLiveData<Categoriespojo> = MutableLiveData()

    fun observeCategoryLiveData(): MutableLiveData<Categoriespojo> {
        return categorydata
    }

    suspend fun getCategory() {
        val response = categoryRepository.getcategorydata()
        if (validateData(response)) {
            categorydata.postValue(response.body())
        }
    }

    private fun validateData(response: Response<Categoriespojo>): Boolean {
        return response.isSuccessful && response.body() != null
    }
}


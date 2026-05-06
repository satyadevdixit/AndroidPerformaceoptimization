package com.example.androidperformanceoptimization.data.network.repo

import com.example.androidperformanceoptimization.data.network.BackendApi
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import retrofit2.Response
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val backendApi: BackendApi
) {

   suspend fun getcategorydata(): Response<Categoriespojo>
    {
        return  backendApi.getcategories()
    }

    suspend fun getPopulationCitiesCount(): Response<PopulationCitiesListPojo>
    {
        return  backendApi.getPopulationCities()
    }
}
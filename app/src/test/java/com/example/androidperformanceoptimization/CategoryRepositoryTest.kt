package com.example.androidperformanceoptimization

import androidx.lifecycle.MutableLiveData
import com.example.androidperformanceoptimization.data.network.BackendApi
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import retrofit2.Response
import javax.inject.Inject

class CategoryRepositoryTest @Inject constructor() {
    /*val categorydata: MutableLiveData<Categoriespojo> = MutableLiveData<Categoriespojo>()
    val populationCitiesListPojo: MutableLiveData<PopulationCitiesListPojo> =
        MutableLiveData<PopulationCitiesListPojo>()
    val populationCitiesListPojo1: MutableLiveData<PopulationCitiesListPojo> =
        MutableLiveData<PopulationCitiesListPojo>()*/

    @Mock
    lateinit var backendApi: BackendApi

    @Before
    fun setUp() {
        backendApi = Mockito.mock(BackendApi::class.java)
    }

    @Test
     fun getcategorydata_emptyData(): Unit = runTest {

        Mockito.`when`(backendApi.getcategories()).thenReturn(Response.success(Categoriespojo()))
        assertEquals(true,backendApi.getcategories() is Response<Categoriespojo>)
        assertEquals(1,backendApi.getcategories().body()?.categories?.size)
    }

    suspend fun getPopulationCitesCount(): Response<PopulationCitiesListPojo>
    {
        return  backendApi.getPopulationCities()
    }
}
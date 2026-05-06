package com.example.androidperformanceoptimization

import com.example.androidperformanceoptimization.data.network.BackendApi
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.model.PopulationCitiesPojo
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Response

class CategoryRepositoryTest {

    private lateinit var backendApi: BackendApi
    private lateinit var repository: CategoryRepository

    @Before
    fun setUp() {
        backendApi = Mockito.mock(BackendApi::class.java)
        repository = CategoryRepository()
        repository.backendApi = backendApi
    }

    @Test
    fun getcategorydata_returnsBackendCategoriesResponse() = runTest {
        val expected = Categoriespojo(
            arrayListOf(CategoriesDetailpojo(currency = "INR", countryName = "India", count = 70))
        )
        Mockito.`when`(backendApi.getcategories()).thenReturn(Response.success(expected))

        val result = repository.getcategorydata()

        assertTrue(result.isSuccessful)
        assertEquals(expected, result.body())
        Mockito.verify(backendApi).getcategories()
    }

    @Test
    fun getPopulationCitesCount_returnsBackendPopulationResponse() = runTest {
        val expected = PopulationCitiesListPojo(
            arrayListOf(PopulationCitiesPojo(city = "Palwal", country = "India"))
        )
        Mockito.`when`(backendApi.getPopulationCities()).thenReturn(Response.success(expected))

        val result = repository.getPopulationCitesCount()

        assertTrue(result.isSuccessful)
        assertEquals(expected, result.body())
        Mockito.verify(backendApi).getPopulationCities()
    }
}

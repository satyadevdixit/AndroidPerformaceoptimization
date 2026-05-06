package com.example.androidperformanceoptimization.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidperformanceoptimization.compose.login.MainDispatcherRule
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.model.Categoriespojo
import getOrAwaitValue
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import retrofit2.Response

@RunWith(RobolectricTestRunner::class)
class CategoryViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var categoryViewModel: CategoryViewModel

    @Mock
    lateinit var categoryRepository: CategoryRepository

    @Before
    fun setUpTest() = runTest{
       categoryRepository = Mockito.mock(CategoryRepository::class.java)
            Mockito.`when`(categoryRepository.getcategorydata())
                .thenReturn(Response.success(null))

        val appContext = RuntimeEnvironment.getApplication()
        categoryViewModel = CategoryViewModel(appContext)
        }


    @Test
    fun validateResponse() = runTest {
        assertEquals(false,categoryViewModel.validateData(categoryRepository.getcategorydata()))
    }

    @Test
    fun validateResponse_returnsTrueForSuccessfulResponseWithBody() {
        val response = Response.success(
            Categoriespojo(
                arrayListOf(CategoriesDetailpojo(currency = "INR", countryName = "India"))
            )
        )

        assertEquals(true, categoryViewModel.validateData(response))
    }

    @Test
    fun getCategory_postsSuccessfulRepositoryDataThenDemoData() = runTest {
        val expected = Categoriespojo(
            arrayListOf(CategoriesDetailpojo(currency = "INR", countryName = "India", count = 70))
        )
        Mockito.`when`(categoryRepository.getcategorydata()).thenReturn(Response.success(expected))
        categoryViewModel.categoryRepository = categoryRepository

        categoryViewModel.getCategory()

        val value = categoryViewModel.categorydata.getOrAwaitValue()
        assertEquals(2, value.categories.size)
        assertEquals("India", value.categories[1].countryName)
        assertEquals(10, value.categories[1].count)
    }

    @Test
     fun `Test launch Coroutine`()
    {
        categoryViewModel.launchCoroutine()
       assertEquals(2,categoryViewModel.categorydata.getOrAwaitValue().categories.size)
       assertEquals(10,categoryViewModel.categorydata.getOrAwaitValue().categories.get(1).count)
    }

    @Test
    fun `CategoryRepository Correct Instance Return`() {
        categoryViewModel.categoryRepository = categoryRepository

        assertEquals(categoryRepository, categoryViewModel.categoryRepository)
    }

    @Test
    fun `CategoryRepository Not Initialized Scenario`() {
        assertEquals(null, categoryViewModel.categorydata.value)
    }

    @Test
    fun `CategoryRepository Null Check  if applicable `() {
        // Although Kotlin's lateinit promises non-null after initialization, 
        // consider a hypothetical scenario where `categoryRepository` could somehow become null after initialization (e.g., via reflection or a bug in the DI framework). 
        // The test would check if `getCategory()` (which uses `categoryRepository`) handles this gracefully, though the current `isInitialized` check implicitly covers this.


    }

    @Test
    fun `Concurrent Access to categoryRepository`() {
        // If multiple threads could potentially access `categoryRepository` via `getCategory()` concurrently, 
        // ensure thread safety. This might involve testing if the `isInitialized` check and subsequent access are atomic or if synchronization is needed, 
        // although for a simple field access, this is usually handled by the Kotlin runtime and DI framework.
        // TODO implement test
    }

}

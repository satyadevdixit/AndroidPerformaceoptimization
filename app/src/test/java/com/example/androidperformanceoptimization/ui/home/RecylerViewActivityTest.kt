package com.example.androidperformanceoptimization.ui.home


import android.app.Application
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.viewmodel.CategoryViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import androidx.arch.core.executor.TaskExecutor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidperformanceoptimization.AppApplication
import com.example.androidperformanceoptimization.data.network.BackendApi
import com.example.androidperformanceoptimization.data.network.repo.CategoryRepository
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import dagger.hilt.android.internal.Contexts.getApplication
import getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import retrofit2.Response

@RunWith(RobolectricTestRunner::class)
class RecylerViewActivityTest {

    val testDispatcher = StandardTestDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
     lateinit var categoryViewModel: CategoryViewModel

    @Mock
    lateinit var backendApi: BackendApi

    @Mock
    lateinit var categoryRepository: CategoryRepository

     @Before
     fun setUp() {
         categoryViewModel = Mockito.mock(CategoryViewModel::class.java)
         backendApi = Mockito.mock(BackendApi::class.java)
         categoryRepository = Mockito.mock(CategoryRepository::class.java)
        // Dispatchers.setMain(testDispatcher)
     }

    @Test
    fun `getCategoryData successfully retrieves and displays categories`() = runTest{
      //  Mockito.`when`(categoryRepository.getcategorydata()).thenReturn(Response.success(Categoriespojo()))
        // Verify that when categoryViewModel.getCategory() returns a valid Categoriespojo, the RecyclerView is populated with the correct data using CategoryAdapter.
        Mockito.`when`(categoryViewModel.observeCategoryLiveData()).thenReturn(MutableLiveData<Categoriespojo>())
      //  Assert.assertEquals(0,categoryViewModel.getCategory().getOrAwaitValue().categories.size)
      // categoryViewModel = CategoryViewModel(ApplicationProvider.getApplicationContext())
       // categoryViewModel.setData()
     //   testDispatcher.scheduler.advanceUntilIdle()
        val result =  categoryViewModel.observeCategoryLiveData()
        result.value = Categoriespojo()

        Assert.assertEquals(1,result.getOrAwaitValue().categories.size)
    }

    @Test
    fun `getCategoryData handles empty category list`() {
        // Verify that when categoryViewModel.getCategory() returns a Categoriespojo with an empty categories list, the RecyclerView is displayed as empty and no errors occur.
        val appContext = RuntimeEnvironment.getApplication()
       val loginViewModel = LoginViewModel(appContext)

        val result = loginViewModel.validateLoginCredentials("gmail.com","password")
        Assert.assertEquals(true,result)
    }

    @Test
    fun `getCategoryData handles null category list in Categoriespojo`() {
        // Verify that when categoryViewModel.getCategory() returns a Categoriespojo where the 'categories' property is null, the app handles this gracefully (e.g., shows an empty list or an error message) without crashing.
        // TODO implement test
    }

    @Test
    fun `getCategoryData handles ViewModel returning null LiveData`() {
        // Verify that if categoryViewModel.getCategory() returns null (for the LiveData object itself), the observer is not triggered and the app doesn't crash.
        // TODO implement test
    }

    @Test
    fun `getCategoryData handles ViewModel throwing an exception`() {
        // Verify how the UI behaves if categoryViewModel.getCategory() (or the LiveData emission) throws an exception. Ensure the app doesn't crash and ideally displays an error state.
        // TODO implement test
    }

    @Test
    fun `getCategoryData observer behavior on activity lifecycle changes`() {
        // Verify that the LiveData observer behaves correctly during activity lifecycle events (e.g., onPause, onStop, onDestroy). Specifically, check if the observer is removed or stops observing when the activity is not active.
        // TODO implement test
    }

    @Test
    fun `getCategoryData with different screen orientations`() {
        // Test if getCategoryData functions correctly after a screen orientation change, ensuring data is re-fetched or restored appropriately and the RecyclerView is updated.
        // TODO implement test
    }

    @Test
    fun `getCategoryData RecyclerView layout manager setup`() {
        // Verify that binding.rvItem.layoutManager is correctly initialized as a LinearLayoutManager with VERTICAL orientation and reverseLayout set to false.
        // TODO implement test
    }

    @Test
    fun `getCategoryData RecyclerView adapter setup`() {
        // Verify that binding.rvItem.adapter is correctly set to an instance of CategoryAdapter.
        // TODO implement test
    }

    @Test
    fun `getCategoryData multiple calls`() {
        // Test the behavior if getCategoryData is called multiple times. Ensure observers are handled correctly (e.g., previous observers are removed or it handles multiple subscriptions gracefully).
        // TODO implement test
    }

    @Test
    fun `getCategoryData with large dataset`() {
        // Test the performance and behavior of getCategoryData when categoryViewModel.getCategory() returns a Categoriespojo with a very large number of categories. Check for UI freezes or memory issues.
        // TODO implement test
    }

    @Test
    fun `getCategoryData when binding object is null  theoretical `() {
        // Although unlikely in this specific onCreate context, consider what would happen if the 'binding' parameter were null. This would likely result in a NullPointerException, but it's an edge case for the method's inputs.
        // TODO implement test
    }

    @Test
    fun `getCategoryData when viewmodel is not injected`() {
        // Test what happens if categoryViewModel is not properly injected (e.g., Hilt setup issue). This would likely lead to a lateinit property not initialized error before getCategory() is called.
        // TODO implement test
    }

    @Test
    fun `getCategoryData LiveData emits multiple values quickly`() {
        // Verify how the UI updates if the LiveData observed by getCategoryData emits new Categoriespojo values in rapid succession. Ensure the UI updates correctly to the latest data without flickering or race conditions.
        // TODO implement test
    }

    @Test
    fun `getCategoryData with invalid data in Categoriespojo items`() {
        // Test the behavior if items within the `it.categories` list have null or unexpected values for properties that CategoryAdapter might use. Ensure the adapter handles this defensively.
        // TODO implement test
    }

}

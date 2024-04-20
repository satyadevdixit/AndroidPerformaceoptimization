package com.example.androidperformanceoptimization.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.viewmodel.CategoryViewModelTest
import com.example.androidperformanceoptimization.viewmodel.PopulationCitiesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RecylerViewActivityTest
{

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    @Test
    fun testRecyclerViewData()
    {

        val observeCategory = Observer<Categoriespojo> {
                it: Categoriespojo ->
            val city = it.categories.get(0).name
            val coutry = it.categories.get(0).count
            val cityname = city
            assertEquals("australiass", city)
        }

        
        val recylerViewActivityViewModel = CategoryViewModelTest(ApplicationProvider.getApplicationContext())
        recylerViewActivityViewModel.getCategory().observeForever(observeCategory)
        runBlocking {
            launch(Dispatchers.Main) { recylerViewActivityViewModel.setCategoryListData()}
        }


    }


    @Test
    fun tardown()
    {
        assertEquals("Hello World","Hello World")
    }

}

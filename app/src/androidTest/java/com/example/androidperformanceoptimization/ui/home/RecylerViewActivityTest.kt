package com.example.androidperformanceoptimization.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.viewmodel.CategoryViewModelTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.assertAll

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
            val countryName = it.categories.get(0).countryName
            val currency = it.categories.get(0).currency

            assertAll("Should return address of Oracle's headquarter",
                {assertEquals("USA", countryName)},
                { assertEquals("Dollar", currency) })
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

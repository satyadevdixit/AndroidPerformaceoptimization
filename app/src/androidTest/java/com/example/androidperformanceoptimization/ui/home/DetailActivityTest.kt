package com.example.androidperformanceoptimization.ui.home


import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import com.example.androidperformanceoptimization.viewmodel.PopulationCitiesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    @Before
    fun setUp() {
    }

    @Test
    fun testData()
    {
        val Observer = Observer<PopulationCitiesListPojo> {
            it:PopulationCitiesListPojo->
            val city = it.populationCitiesList.get(0).city
            val coutry = it.populationCitiesList.get(0).country
           // Log.e("Androidtest",city.toString())
            assertEquals("palwal", "hello")
        }

        val Observercity = Observer<PopulationCitiesListPojo> {
                it:PopulationCitiesListPojo->
            val city = it.populationCitiesList.get(0).city
            val coutry = it.populationCitiesList.get(0).country
            // Log.e("Androidtest",city.toString())
            assertEquals("India", coutry)
        }

      val detailActivityViewModel = PopulationCitiesViewModel(ApplicationProvider.getApplicationContext())
      //  detailActivityViewModel.setData("Fridabad","Haryana")
        //detailActivityViewModel.city.observeForever(Observercity)
        detailActivityViewModel.createDummyData().observeForever(Observercity)
        runBlocking {
         //   launch(Dispatchers.Main) { detailActivityViewModel.getPopulationCities(true).observeForever(Observer) }
            launch(Dispatchers.Main) { detailActivityViewModel.setCityListData()}
        }
    }

    }
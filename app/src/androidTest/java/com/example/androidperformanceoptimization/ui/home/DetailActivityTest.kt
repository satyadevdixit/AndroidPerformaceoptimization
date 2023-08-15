package com.example.androidperformanceoptimization.ui.home


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import com.example.androidperformanceoptimization.viewmodel.PopulationCitiesViewModel
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

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
            assertTrue(city.equals("Palwal"))
        }
      val detailActivityViewModel = PopulationCitiesViewModel(ApplicationProvider.getApplicationContext())
        runBlockingTest {
            detailActivityViewModel.getPopulationCities(true).observeForever(Observer)
        }
    }

    }
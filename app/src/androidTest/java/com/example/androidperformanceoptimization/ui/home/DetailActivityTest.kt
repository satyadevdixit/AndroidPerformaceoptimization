package com.example.androidperformanceoptimization.ui.home


import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidperformanceoptimization.CommonRule
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.getOrAwaitValue
import com.example.androidperformanceoptimization.model.Categoriespojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.viewmodel.CategoryViewModelTest
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import com.example.androidperformanceoptimization.viewmodel.PopulationCitiesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.assertAll
import org.junit.runner.RunWith


class DetailActivityTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    val dispatcher = StandardTestDispatcher()

    @get:Rule
    var activity = activityScenarioRule<DetailActivity>()

    @get:Rule
    var commonRule = CommonRule()

  // lateinit var detailActivityViewModel:PopulationCitiesViewModel
//    @Before
//    fun setUp() {
//        detailActivityViewModel = PopulationCitiesViewModel(ApplicationProvider.getApplicationContext())
//     /*  Dispatchers.setMain(dispatcher)
//        runTest {
//            detailActivityViewModel.setData("Palwal1","dixit") }
//
//        dispatcher.scheduler.advanceUntilIdle()
//        val latestValue =  detailActivityViewModel.city.getOrAwaitValue()*/
//    }

    @Test
    fun testData()
    {
        val observeCategory = Observer<String> {
                it: String ->
            val countryName = it
//            val currency = it.categories.get(0).currency

           // onView(withId(R.id.text_view_city_name)).check(matches(withText(countryName)))
           assertEquals("Palwal", countryName)
           /* assertAll("Should return address of Oracle's headquarter",
                {
                    assertEquals("USA", countryName)},
                {
                    assertEquals("Dollar", currency) })*/
        }



       commonRule.detailActivityViewModel.city.observeForever(observeCategory)
        runBlocking {
            dispatcher.scheduler.advanceUntilIdle()
            launch(Dispatchers.Main) { commonRule.detailActivityViewModel.setData("Palwal","dixit")}
        }



//onView(withId(R.id.text_view_city_name)).check(matches(withText("Palwal")))

       // onView(withId(R.id.text_view_country_name)).perform(click())
       // onView(withId(R.id.text_view_city_name)).check(matches(withText("palwal7")))
    }

    }
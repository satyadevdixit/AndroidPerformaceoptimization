package com.example.androidperformanceoptimization.ui.home


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.androidperformanceoptimization.CommonRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Assert.*

import org.junit.Rule
import org.junit.Test


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
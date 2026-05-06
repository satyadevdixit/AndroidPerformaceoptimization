package com.example.androidperformanceoptimization.compose

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.composepractise.listexample.ListViewModel
import com.example.composepractise.questionexample.QuestionViewModel
import com.example.composepractise.utility.topappbar.TopAppBarWeatherViewModel
import com.example.composepractise.weather.WeatherViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class ComposeViewModelsTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun listViewModel_addsAndRemovesItems() {
        val viewModel = ListViewModel()

        viewModel.addItemInList("Kotlin")
        viewModel.addItemInList("Compose")
        viewModel.removeItemInList("Kotlin")

        assertEquals(listOf("Compose"), viewModel.getLanguageList().toList())
    }

    @Test
    fun questionViewModel_returnsExpectedQuestionBank() {
        val questions = QuestionViewModel().getQuestionsList()

        assertEquals(5, questions.size)
        assertEquals("Whats is your name", questions.first().question)
        assertTrue(questions.first().optionsList.contains(questions.first().answer))
    }

    @Test
    fun weatherViewModel_returnsForecastDataAndPublishesSearchText() {
        val viewModel = WeatherViewModel()

        viewModel.searchDetailMutableLiveData.value = "Delhi"
        val weather = viewModel.getWeatherDayList()

        assertEquals("Delhi", viewModel.searchDetailLiveData.value)
        assertEquals(8, weather.size)
        assertEquals("thur", weather.first().day)
    }

    @Test
    fun topAppBarWeatherViewModel_returnsForecastDataAndPublishesSearchText() {
        val viewModel = TopAppBarWeatherViewModel()

        viewModel.searchDetailMutableLiveData.value = "Mumbai"
        val weather = viewModel.getWeatherDayList()

        assertEquals("Mumbai", viewModel.searchDetailLiveData.value)
        assertEquals(8, weather.size)
        assertEquals("thur", weather.first().day)
    }
}

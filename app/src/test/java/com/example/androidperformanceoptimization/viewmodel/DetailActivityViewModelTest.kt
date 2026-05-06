package com.example.androidperformanceoptimization.viewmodel

import android.os.Bundle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class DetailActivityViewModelTest {

    private lateinit var viewModel: DetailActivityViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUptest() {
        viewModel = DetailActivityViewModel(RuntimeEnvironment.getApplication())
    }

    @Test
    fun setData_updatesCityAndCountryLiveData() {
        viewModel.setData("Palwal", "India")

        assertEquals("Palwal", viewModel.city.value)
        assertEquals("India", viewModel.country.value)
    }

    @Test
    fun validatedata_withNullBundle_returnsFalse() {
        assertEquals(false, viewModel.validatedata(null))
    }

    @Test
    fun validatedata_withEmptyBundle_returnsFalse() {
        assertEquals(false, viewModel.validatedata(Bundle()))
    }

    @Test
    fun validatedata_withMissingCountryName_returnsFalse() {
        val bundle = Bundle().apply {
            putString("currency", "rupee")
        }

        assertEquals(false, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withMissingCurrency_returnsFalse() {
        val bundle = Bundle().apply {
            putString("countryname", "India")
        }

        assertEquals(false, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withNullCountryName_returnsFalse() {
        val bundle = Bundle().apply {
            putString("countryname", null)
            putString("currency", "rupee")
        }

        assertEquals(false, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withNullCurrency_returnsFalse() {
        val bundle = Bundle().apply {
            putString("countryname", "India")
            putString("currency", null)
        }

        assertEquals(false, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withEmptyCountryName_returnsTrueBecauseKeyAndNonNullValueExist() {
        val bundle = Bundle().apply {
            putString("countryname", "")
            putString("currency", "rupee")
        }

        assertEquals(true, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withEmptyCurrency_returnsTrueBecauseKeyAndNonNullValueExist() {
        val bundle = Bundle().apply {
            putString("countryname", "India")
            putString("currency", "")
        }

        assertEquals(true, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withValidBundle_returnsTrue() {
        val bundle = Bundle().apply {
            putString("countryname", "India")
            putString("currency", "rupee")
        }

        assertEquals(true, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withExtraKeys_returnsTrue() {
        val bundle = Bundle().apply {
            putString("countryname", "India")
            putString("currency", "rupee")
            putString("extra", "ignored")
        }

        assertEquals(true, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withNonStringCountryName_returnsFalse() {
        val bundle = Bundle().apply {
            putInt("countryname", 91)
            putString("currency", "rupee")
        }

        assertEquals(false, viewModel.validatedata(bundle))
    }

    @Test
    fun validatedata_withNonStringCurrency_returnsFalse() {
        val bundle = Bundle().apply {
            putString("countryname", "India")
            putInt("currency", 91)
        }

        assertEquals(false, viewModel.validatedata(bundle))
    }
}

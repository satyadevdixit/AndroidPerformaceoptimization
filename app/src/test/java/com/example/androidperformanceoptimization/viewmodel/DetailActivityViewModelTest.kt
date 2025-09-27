package com.example.androidperformanceoptimization.viewmodel

import android.os.Bundle
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class DetailActivityViewModelTest {

    private lateinit var viewModel: DetailActivityViewModel

    @Before
    fun setUptest(){
            viewModel = DetailActivityViewModel(RuntimeEnvironment.getApplication())
    }

    @Test
    fun `ValidateData with null bundle`() {
        // Test if the function returns false when the input bundle is null.
        // TODO implement test
        val result = viewModel.validatedata(null)
        assertEquals(false,result)
    }

    @Test
    fun `ValidateData with empty bundle`() {
        // Test if the function returns false when the input bundle is empty.
        // TODO implement test
        val bundle = Bundle()
        bundle.putSerializable("currency","rupee")
        bundle.putSerializable("countryname","India")

        val result = viewModel.validatedata(bundle)
        assertEquals(true,result)
    }

    @Test
    fun `ValidateData with bundle missing  countryname  key`() {
        // Test if the function returns false when the input bundle does not contain the 'countryname' key.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle missing  currency  key`() {
        // Test if the function returns false when the input bundle does not contain the 'currency' key.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle having null  countryname  value`() {
        // Test if the function returns false when the 'countryname' value in the bundle is null.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle having null  currency  value`() {
        // Test if the function returns false when the 'currency' value in the bundle is null.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle having empty string for  countryname `() {
        // Test if the function returns true when the 'countryname' value in the bundle is an empty string, but present.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle having empty string for  currency `() {
        // Test if the function returns true when the 'currency' value in the bundle is an empty string, but present.
        // TODO implement test
    }

    @Test
    fun `ValidateData with valid bundle containing all required keys and non null values`() {
        // Test if the function returns true when the bundle contains both 'countryname' and 'currency' keys with non-null string values.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle containing extra keys`() {
        // Test if the function returns true when the bundle contains 'countryname' and 'currency' with non-null values, along with other unrelated keys.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle where  countryname  is not a string`() {
        // Test if the function still returns true if 'countryname' key exists and its value is not null, even if the value is not a String (though getString will return null in this case if it's not a String, leading to false). 
        // This tests the robustness against unexpected data types for keys that are expected to be strings.
        // TODO implement test
    }

    @Test
    fun `ValidateData with bundle where  currency  is not a string`() {
        // Test if the function still returns true if 'currency' key exists and its value is not null, even if the value is not a String (though getString will return null in this case if it's not a String, leading to false). 
        // This tests the robustness against unexpected data types for keys that are expected to be strings.
        // TODO implement test
    }

}
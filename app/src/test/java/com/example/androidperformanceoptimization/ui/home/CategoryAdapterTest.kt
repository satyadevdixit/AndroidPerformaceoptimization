package com.example.androidperformanceoptimization.ui.home

import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class CategoryAdapterTest {

    @Test
    fun itemCount_matchesCategoryListSize() {
        val adapter = CategoryAdapter(
            mutableListOf(
                CategoriesDetailpojo(currency = "INR"),
                CategoriesDetailpojo(currency = "USD")
            ),
            RuntimeEnvironment.getApplication()
        )

        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun validateCountvalue_returnsTrueOnlyInsideBounds() {
        val adapter = CategoryAdapter(mutableListOf(), RuntimeEnvironment.getApplication())

        assertTrue(adapter.validateCountvalue(currentValue = 51, lowLimitValue = 50, maxLimitValue = 90))
        assertFalse(adapter.validateCountvalue(currentValue = 50, lowLimitValue = 50, maxLimitValue = 90))
        assertFalse(adapter.validateCountvalue(currentValue = 90, lowLimitValue = 50, maxLimitValue = 90))
    }
}

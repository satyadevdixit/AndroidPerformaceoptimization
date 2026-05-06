package com.example.androidperformanceoptimization.ui.home

import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CategoryDifutilTest {

    @Test
    fun listSizes_reflectOldAndNewLists() {
        val oldList = listOf(CategoriesDetailpojo(currency = "INR"))
        val newList = listOf(
            CategoriesDetailpojo(currency = "INR"),
            CategoriesDetailpojo(currency = "USD")
        )

        val diff = CategoryDifutil(newlist = newList, oldlist = oldList)

        assertEquals(1, diff.oldListSize)
        assertEquals(2, diff.newListSize)
    }

    @Test
    fun areItemsTheSame_usesCurrencyAsIdentity() {
        val diff = CategoryDifutil(
            newlist = listOf(CategoriesDetailpojo(currency = "INR", countryName = "Bharat")),
            oldlist = listOf(CategoriesDetailpojo(currency = "INR", countryName = "India"))
        )

        assertTrue(diff.areItemsTheSame(0, 0))
    }

    @Test
    fun areContentsTheSame_returnsFalseWhenCurrencyAndCountryChange() {
        val diff = CategoryDifutil(
            newlist = listOf(CategoriesDetailpojo(currency = "USD", countryName = "USA")),
            oldlist = listOf(CategoriesDetailpojo(currency = "INR", countryName = "India"))
        )

        assertFalse(diff.areContentsTheSame(0, 0))
    }
}

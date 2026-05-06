package com.example.androidperformanceoptimization.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ModelDefaultsTest {

    @Test
    fun categoriesPojo_defaultsToOneEmptyCategory() {
        val pojo = Categoriespojo()

        assertEquals(1, pojo.categories.size)
        assertNull(pojo.categories.first().currency)
        assertNull(pojo.categories.first().countryName)
        assertEquals(70, pojo.categories.first().count)
    }

    @Test
    fun categoriesDetailPojo_keepsProvidedValues() {
        val detail = CategoriesDetailpojo(currency = "INR", countryName = "India", count = 12)

        assertEquals("INR", detail.currency)
        assertEquals("India", detail.countryName)
        assertEquals(12, detail.count)
    }

    @Test
    fun populationCitiesList_defaultsToEmptyList() {
        val pojo = PopulationCitiesListPojo()

        assertEquals(0, pojo.populationCitiesList.size)
    }

    @Test
    fun populationCitiesPojo_keepsCityCountryAndPopulationCounts() {
        val populationCount = PopulationCountDetail(year = "2020", sex = "Both")
        val pojo = PopulationCitiesPojo(
            city = "Palwal",
            country = "India",
            populationCounts = arrayListOf(populationCount)
        )

        assertEquals("Palwal", pojo.city)
        assertEquals("India", pojo.country)
        assertEquals(populationCount, pojo.populationCounts.first())
    }
}

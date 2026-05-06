package com.example.androidperformanceoptimization.data.network

import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.http.GET

class BackendApiContractTest {

    @Test
    fun getcategories_usesCurrencyEndpoint() {
        val annotation = BackendApi::class.java
            .getMethod("getcategories", kotlin.coroutines.Continuation::class.java)
            .getAnnotation(GET::class.java)

        assertEquals("countries/currency/", annotation.value)
    }

    @Test
    fun getPopulationCities_usesPopulationCitiesEndpoint() {
        val annotation = BackendApi::class.java
            .getMethod("getPopulationCities", kotlin.coroutines.Continuation::class.java)
            .getAnnotation(GET::class.java)

        assertEquals("countries/population/cities", annotation.value)
    }
}

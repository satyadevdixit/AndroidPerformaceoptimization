package com.example.androidperformanceoptimization.adapter

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.ui.home.CategoryAdapter
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountryAdapterTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun validateCountvalue() {
        val categoryAdapter:CategoryAdapter = CategoryAdapter(mutableListOf(),ApplicationProvider.getApplicationContext())
        assertTrue(categoryAdapter.validateCountvalue(45,70,90)==true)
    }
}
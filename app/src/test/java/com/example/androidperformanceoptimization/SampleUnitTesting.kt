package com.example.androidperformanceoptimization

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

class SampleUnitTesting {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
}
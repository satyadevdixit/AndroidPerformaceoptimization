package com.example.androidperformanceoptimization

import androidx.test.core.app.ApplicationProvider
import com.example.androidperformanceoptimization.viewmodel.PopulationCitiesViewModel
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class CommonRule:TestWatcher() {

    lateinit var detailActivityViewModel:PopulationCitiesViewModel

    override fun starting(description: Description?) {
        super.starting(description)
        detailActivityViewModel = PopulationCitiesViewModel(ApplicationProvider.getApplicationContext())
    }

    override fun finished(description: Description?) {
        super.finished(description)
    }
}
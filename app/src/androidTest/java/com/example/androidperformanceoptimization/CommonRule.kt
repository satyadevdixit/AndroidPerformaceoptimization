package com.example.androidperformanceoptimization

import androidx.test.core.app.ApplicationProvider
import com.example.androidperformanceoptimization.viewmodel.DetailActivityViewModel
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class CommonRule:TestWatcher() {

    lateinit var detailActivityViewModel:DetailActivityViewModel

    override fun starting(description: Description?) {
        super.starting(description)
        detailActivityViewModel = DetailActivityViewModel(ApplicationProvider.getApplicationContext())
    }

    override fun finished(description: Description?) {
        super.finished(description)
    }
}
package com.example.androidperformanceoptimization.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.databinding.ActivityDetailBinding
import com.example.androidperformanceoptimization.viewmodel.DetailActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val populationCitiesViewModel: DetailActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding : ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)
        setData(intent.getBundleExtra("data"))

        binding.detail = populationCitiesViewModel
        binding.lifecycleOwner = this
        binding.textViewCountryName.setOnClickListener { binding.textViewCityName.setText("palwal7") }
    }

    fun setData(bundle: Bundle?)
    {
        if (!populationCitiesViewModel.validatedata(bundle)) return
        val countryName = bundle?.getString("countryname") ?: return
        val currency = bundle.getString("currency") ?: return
        populationCitiesViewModel.setData(countryName, currency)
    }
}
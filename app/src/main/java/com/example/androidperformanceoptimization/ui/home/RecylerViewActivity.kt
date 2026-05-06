package com.example.androidperformanceoptimization.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidperformanceoptimization.viewmodel.CategoryViewModel
import com.example.androidperformanceoptimization.R

import com.example.androidperformanceoptimization.databinding.ActivityMainBinding
import com.example.androidperformanceoptimization.model.Categoriespojo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecyclerViewActivity : AppCompatActivity() {

    private val categoryViewModel: CategoryViewModel by viewModels()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView(binding)
        getCategoryData()
    }

    private fun setupRecyclerView(binding: ActivityMainBinding) {
        categoryAdapter = CategoryAdapter(this@RecyclerViewActivity)
        binding.rvItem.layoutManager =
            LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = categoryAdapter
    }

    fun getCategoryData()
    {
        categoryViewModel.observeCategoryLiveData().observe(this@RecyclerViewActivity) { it ->
            setCategoryData(it)
        }
        lifecycleScope.launch {
            categoryViewModel.getCategory()
        }
    }

    fun setCategoryData(categoriespojo: Categoriespojo)
    {
        categoryAdapter.submitList(categoriespojo.categories.toList())
    }
}
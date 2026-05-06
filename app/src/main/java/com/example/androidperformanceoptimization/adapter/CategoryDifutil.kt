package com.example.androidperformanceoptimization.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo

object CategoryDiffUtil : DiffUtil.ItemCallback<CategoriesDetailpojo>() {

    const val ARG_COUNTRY_NAME = "arg.country.name"
    const val ARG_COUNT = "arg.count"

    override fun areItemsTheSame(
        oldItem: CategoriesDetailpojo,
        newItem: CategoriesDetailpojo
    ): Boolean {
        return oldItem.currency == newItem.currency && oldItem.countryName == newItem.countryName
    }

    override fun areContentsTheSame(
        oldItem: CategoriesDetailpojo,
        newItem: CategoriesDetailpojo
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(
        oldItem: CategoriesDetailpojo,
        newItem: CategoriesDetailpojo
    ): Any? {
        val diff = Bundle()
        if (oldItem.countryName != newItem.countryName) {
            diff.putString(ARG_COUNTRY_NAME, newItem.countryName)
        }
        if (oldItem.count != newItem.count) {
            diff.putInt(ARG_COUNT, newItem.count)
        }
        return if (diff.isEmpty) null else diff
    }
}
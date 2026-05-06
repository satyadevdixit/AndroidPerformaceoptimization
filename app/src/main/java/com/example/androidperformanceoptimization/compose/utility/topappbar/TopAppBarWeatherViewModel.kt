package com.example.composepractise.utility.topappbar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidperformanceoptimization.R

class TopAppBarWeatherViewModel :ViewModel() {
    var searchDetailMutableLiveData = MutableLiveData<String>()
    val searchDetailLiveData: LiveData<String> get() = searchDetailMutableLiveData
    private val weatherList = listOf(
        TopAppBarWeatherListData("thur", R.drawable.cloud_fog_svgrepo_com, "light rain", 45, 23),
        TopAppBarWeatherListData("fri", R.drawable.cloud_fog_svgrepo_com, "rain", 50, 20),
        TopAppBarWeatherListData("mon", R.drawable.cloud_fog_svgrepo_com, "heavy rain", 55, 21),
        TopAppBarWeatherListData("tue", R.drawable.cloud_fog_svgrepo_com, "thunderbolt", 51, 25),
        TopAppBarWeatherListData("wed", R.drawable.cloud_fog_svgrepo_com, "light rain", 45, 26),
        TopAppBarWeatherListData("sat", R.drawable.cloud_fog_svgrepo_com, "light rain", 41, 28),
        TopAppBarWeatherListData("sun", R.drawable.cloud_fog_svgrepo_com, "light rain", 40, 29),
        TopAppBarWeatherListData("thu", R.drawable.cloud_fog_svgrepo_com, "light rain", 42, 22)
    )

    fun getWeatherDayList(): List<TopAppBarWeatherListData>
    {
        return weatherList
    }
}
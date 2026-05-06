package com.example.composepractise.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidperformanceoptimization.R

class WeatherViewModel :ViewModel() {
    var searchDetailMutableLiveData = MutableLiveData<String>()
    val searchDetailLiveData: LiveData<String> get() = searchDetailMutableLiveData
    private val weatherList = listOf(
        WeatherListData("thur", R.drawable.cloud_fog_svgrepo_com, "light rain", 45, 23),
        WeatherListData("fri", R.drawable.cloud_fog_svgrepo_com, "rain", 50, 20),
        WeatherListData("mon", R.drawable.cloud_fog_svgrepo_com, "heavy rain", 55, 21),
        WeatherListData("tue", R.drawable.cloud_fog_svgrepo_com, "thunderbolt", 51, 25),
        WeatherListData("wed", R.drawable.cloud_fog_svgrepo_com, "light rain", 45, 26),
        WeatherListData("sat", R.drawable.cloud_fog_svgrepo_com, "light rain", 41, 28),
        WeatherListData("sun", R.drawable.cloud_fog_svgrepo_com, "light rain", 40, 29),
        WeatherListData("thu", R.drawable.cloud_fog_svgrepo_com, "light rain", 42, 22)
    )

    fun getWeatherDayList(): List<WeatherListData>
    {
        return weatherList
    }
}
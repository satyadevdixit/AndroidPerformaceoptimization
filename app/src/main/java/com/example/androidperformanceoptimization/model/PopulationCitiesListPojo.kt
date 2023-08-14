package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName

data class PopulationCitiesListPojo(
@SerializedName("data")  var populationCitiesList : ArrayList<PopulationCitiesPojo> = arrayListOf())

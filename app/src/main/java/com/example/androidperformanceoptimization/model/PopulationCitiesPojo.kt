package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName

data class PopulationCitiesPojo(
    @SerializedName("city") var city   : String    ,
    @SerializedName("country") var country : String ,
    @SerializedName("populationCounts") var populationCounts : ArrayList<PopulationCountDetail> = arrayListOf()
)
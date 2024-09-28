package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName


data class CategoriesDetailpojo (
 @SerializedName("currency") var currency   : String?    = null,
 @SerializedName("name") var countryName : String? = null,
 var count : Int = 70

)
package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName


data class CategoriesDetailpojo (
 @SerializedName("id") var id   : Int?    = null,
 @SerializedName("name") var name : String? = null

)
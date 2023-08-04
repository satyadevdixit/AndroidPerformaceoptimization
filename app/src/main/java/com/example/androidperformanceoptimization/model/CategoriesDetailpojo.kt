package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName


data class CategoriesDetailpojo (
 @SerializedName("currency") var id   : String?    = null,
 @SerializedName("name") var name : String? = null

)
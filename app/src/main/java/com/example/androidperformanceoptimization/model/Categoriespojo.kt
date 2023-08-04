package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName


data class Categoriespojo (

 @SerializedName("data") var categories : ArrayList<CategoriesDetailpojo> = arrayListOf()

)
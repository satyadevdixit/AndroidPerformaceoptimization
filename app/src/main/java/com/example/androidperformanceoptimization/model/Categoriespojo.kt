package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName


data class Categoriespojo (

 @SerializedName("categories") var categories : ArrayList<Categoryitempojo> = arrayListOf()

)
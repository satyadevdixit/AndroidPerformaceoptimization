package com.example.androidperformanceoptimization.model

import com.google.gson.annotations.SerializedName

data class PopulationCountDetail(@SerializedName("year") var year   : String?    = null,
                                 @SerializedName("sex") var sex : String? = null)

package com.faizdev.ourhadith.models


import com.google.gson.annotations.SerializedName

data class PerawiResponseItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("total")
    val total: Int
)
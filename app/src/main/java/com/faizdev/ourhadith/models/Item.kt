package com.faizdev.ourhadith.models


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("arab")
    val arab: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("number")
    val number: Int
)
package com.faizdev.ourhadith.models


import com.google.gson.annotations.SerializedName

data class HadithResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("name")
    val name: String,
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("total")
    val total: Int
)
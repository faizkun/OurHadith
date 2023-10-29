package com.faizdev.ourhadith.models


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("endIndex")
    val endIndex: Int,
    @SerializedName("endPage")
    val endPage: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("pages")
    val pages: List<Int>,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("startPage")
    val startPage: Int,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Any
)
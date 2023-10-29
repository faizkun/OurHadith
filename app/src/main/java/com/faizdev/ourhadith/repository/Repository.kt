package com.faizdev.ourhadith.repository

import com.faizdev.ourhadith.API.HadithApi

class Repository(private val hadithApi: HadithApi) {
     suspend fun getPerawi() = hadithApi.getPerawi()
    suspend fun getHadith(perawi: String, page: Int) = hadithApi.getHadith(perawi, page)
    suspend fun searchHadith(perawi: String, noHadith: Int) = hadithApi.searchHadith(perawi, noHadith)
}


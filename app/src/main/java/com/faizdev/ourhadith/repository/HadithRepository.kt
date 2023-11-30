package com.faizdev.ourhadith.repository

import androidx.paging.PagingData
import com.faizdev.ourhadith.models.Item
import com.faizdev.ourhadith.models.Pagination
import com.faizdev.ourhadith.models.PerawiResponse
import com.faizdev.ourhadith.models.SearchHadithResponse
import kotlinx.coroutines.flow.Flow

interface HadithRepository{
    suspend fun getPerawi(): PerawiResponse

    fun getHadith(
        perawiSlugName: String,
        perawiName: (String) -> Unit,
    ): Flow<PagingData<Item>>

    suspend fun search(
        perawi: String,
        nomorHadis: Int
    ): SearchHadithResponse
}
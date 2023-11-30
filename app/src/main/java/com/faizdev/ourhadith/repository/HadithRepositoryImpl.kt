package com.faizdev.ourhadith.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.faizdev.ourhadith.API.HadithApi
import com.faizdev.ourhadith.models.HadithResponse
import com.faizdev.ourhadith.models.Item
import com.faizdev.ourhadith.models.PerawiResponse
import com.faizdev.ourhadith.models.SearchHadithResponse
import com.faizdev.ourhadith.paging.HadithPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class HadithRepositoryImpl(val haditsApi: HadithApi) : HadithRepository{

    override suspend fun getPerawi(): PerawiResponse {
        return haditsApi.getPerawi()
    }

    override fun getHadith(
        perawiSlugName: String,
        perawiName: (String) -> Unit
    ): Flow<PagingData<Item>> =
        Pager(
        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = {
            HadithPagingSource(
                haditsApi,
                perawiSlugName,
                perawiName

            )
        }
    ).flow.flowOn(Dispatchers.Default)

    override suspend fun search(perawi: String, nomorHadis: Int): SearchHadithResponse {
        return haditsApi.searchHadith(perawi, nomorHadis)
    }

}
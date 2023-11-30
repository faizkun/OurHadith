package com.faizdev.ourhadith.API


import com.faizdev.ourhadith.models.HadithResponse
import com.faizdev.ourhadith.models.PerawiResponse
import com.faizdev.ourhadith.models.SearchHadithResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HadithApi {

    @GET("hadith")
    suspend fun getPerawi(): PerawiResponse

    @GET("hadith/{perawiSlug}")
    suspend fun getHadith(
        @Path("perawiSlug") perawi : String,
        @Query("page") page : Int = 1,
        @Query("limit") limit: Int = 20
        ) : HadithResponse

    @GET("hadith/{perawiSlug}/{nomorHadis}")
        suspend fun searchHadith(
            @Path("perawiSlug") perawi: String,
            @Path("nomorHadis") nomorHadis : Int
        ): SearchHadithResponse
}




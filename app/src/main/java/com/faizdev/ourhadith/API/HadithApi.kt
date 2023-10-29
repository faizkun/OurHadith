package com.faizdev.ourhadith.API

import androidx.viewpager2.widget.ViewPager2.OffscreenPageLimit
import com.faizdev.ourhadith.models.HadithResponse
import com.faizdev.ourhadith.models.PerawiResponse
import com.faizdev.ourhadith.models.SearchHadithResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface HadithApi {

    companion object {
        private const val BASE_URL = "https://hadis-api-id.vercel.app/"
        fun createApi() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HadithApi::class.java)




    }

    @GET("hadith")
    suspend fun getPerawi(): PerawiResponse

    @GET("hadith/{perawiSlug}{page}{limit}")
    suspend fun getHadith(
        @Path("perawiSlug") perawi : String,
        @Path("page") page : Int,
        @Path("limit") limit: Int = 20
        ) : HadithResponse

    @GET("hadith/{perawiSlug}/{nomorHadis}")
        suspend fun searchHadith(
            @Path("perawiSlug") perawi: String,
            @Path("nomorHadis") nomorHadis : Int
        ): SearchHadithResponse
}




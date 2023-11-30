package com.faizdev.ourhadith.di

import com.faizdev.ourhadith.API.HadithApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Injection {
    companion object {
        private const val BASE_URL = "https://hadis-api-id.vercel.app/"
        fun createApi() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HadithApi::class.java)




    }
}
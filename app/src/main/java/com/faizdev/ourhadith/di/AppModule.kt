package com.faizdev.ourhadith.di

import com.faizdev.ourhadith.API.HadithApi
import com.faizdev.ourhadith.repository.HadithRepository
import com.faizdev.ourhadith.repository.HadithRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppModule {
    val hadithApi: HadithApi
    val hadithRepository: HadithRepository
}

class AppModuleImpl : AppModule {
    override val hadithApi: HadithApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://hadis-api-id.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HadithApi::class.java)
    }

    override val hadithRepository: HadithRepository by lazy {
        HadithRepositoryImpl(hadithApi)
    }
}
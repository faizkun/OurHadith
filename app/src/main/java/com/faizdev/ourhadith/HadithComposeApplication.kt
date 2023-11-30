package com.faizdev.ourhadith

import android.app.Application
import com.faizdev.ourhadith.di.AppModule
import com.faizdev.ourhadith.di.AppModuleImpl
import com.faizdev.ourhadith.repository.HadithRepository
import com.faizdev.ourhadith.repository.HadithRepositoryImpl

class HadithComposeApplication : Application(){
    companion object{
        lateinit var repository: HadithRepository
        private lateinit var appModule: AppModule
    }
    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl()
        repository = HadithRepositoryImpl(appModule.hadithApi)
    }
}
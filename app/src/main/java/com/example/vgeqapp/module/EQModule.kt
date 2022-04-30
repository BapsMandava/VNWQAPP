package com.example.vgeqapp.module

import com.example.vgeqapp.api.EQOkHttpHelper
import com.example.vgeqapp.api.EQService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object EQModule {

    @Provides
    fun providesEQService(
        eqserviceOKHTTPHelper:EQOkHttpHelper
    ) : EQService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://earthquake.usgs.gov/earthquakes/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(eqserviceOKHTTPHelper.buildOKHttpClient())
            .build()
        return retrofit.create(EQService::class.java)
    }
}
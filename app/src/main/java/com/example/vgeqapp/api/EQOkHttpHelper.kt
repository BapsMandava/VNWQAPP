package com.example.vgeqapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EQOkHttpHelper @Inject constructor() {

    fun buildOKHttpClient() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .connectTimeout(5,TimeUnit.SECONDS)
            .build()
    }
}
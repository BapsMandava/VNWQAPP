package com.example.vgeqapp.api

import com.example.vgeqapp.model.EarthQuakeDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface EQService {

    @GET("feed/v1.0/summary/all_hour.geojson")
    suspend fun getLatestEQData(): Response<EarthQuakeDataResponse>
}
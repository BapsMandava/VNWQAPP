package com.example.vgeqapp.api

import javax.inject.Inject

class EQServiceHelper @Inject constructor(private val eqService: EQService) {
    suspend fun getLatesEQData() = eqService.getLatestEQData()
}
package com.example.vgeqapp.repository

import com.example.vgeqapp.api.EQServiceHelper
import com.example.vgeqapp.utils.Transform
import javax.inject.Inject

class EQRepository @Inject constructor(val eqServiceHelper: EQServiceHelper){

    suspend fun getLatestEQData() = Transform.convertResponsetoData(eqServiceHelper.getLatesEQData().body())
}
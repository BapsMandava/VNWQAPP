package com.example.vgeqapp.utils

import com.example.vgeqapp.R
import com.example.vgeqapp.data.EQData
import com.example.vgeqapp.extentions.convertLongToTime
import com.example.vgeqapp.model.EarthQuakeDataResponse

object Transform {

    fun convertResponsetoData(response: EarthQuakeDataResponse?) : List<EQData> {
        var eqDataList = mutableListOf<EQData>()
        var colorCode : Int = 0
        response?.features?.forEach {
            if(it.properties.mag in 0.0..0.9){
                colorCode = R.color.green
            } else if(it.properties.mag in 9.0..9.9) {
                colorCode = R.color.red
            } else {
                colorCode = R.color.yellow

            }
            eqDataList.add(EQData(id = it.id,
                magnitude = it.properties.mag.toString(),
            place = it.properties.place,
            date = it.properties.updated.convertLongToTime(),
            indicator = colorCode))
        }
        return eqDataList
    }
}
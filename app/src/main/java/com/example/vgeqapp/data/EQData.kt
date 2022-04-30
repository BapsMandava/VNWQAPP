package com.example.vgeqapp.data

data class EQData(
    var id : String? = "",
    var magnitude:String? = "",
    var place: String? = "",
    var date: String? = "",
    var longitude: Double,
    var latitude: Double,
    var depth: Double,
    var indicator: Int? = 0
)

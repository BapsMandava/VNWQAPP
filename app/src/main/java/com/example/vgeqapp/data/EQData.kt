package com.example.vgeqapp.data

data class EQData(
    var id : String? = "",
    var magnitude:String? = "",
    var place: String? = "",
    var date: String? = "",
    var longitude: String? = "",
    var latitude: String? = "",
    var depth: String? = "",
    var indicator: Int? = 0
)

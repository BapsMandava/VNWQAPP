package com.example.vgeqapp.model

data class EarthQuakeDataResponse(
    val type: String,
    val metadata: Metadata,
    val features: List<Feature>,
    val bbox: List<Double>
)
data class Feature (
    val type: String,
    val properties: Properties,
    val geometry: Geometry,
    val id: String
)

data class Geometry (
    val type: String,
    val coordinates: List<Double>
)

data class Properties (
    val mag: Double,
    val place: String,
    val time: Long,
    val updated: Long,
    val tz: Any? = null,
    val url: String,
    val detail: String,
    val felt: Any? = null,
    val cdi: Any? = null,
    val mmi: Any? = null,
    val alert: Any? = null,
    val status: String,
    val tsunami: Long,
    val sig: Long,
    val net: String,
    val code: String,
    val ids: String,
    val sources: String,
    val types: String,
    val nst: Long? = null,
    val dmin: Double? = null,
    val rms: Double,
    val gap: Double? = null,
    val magType: String,
    val type: String,
    val title: String
)

data class Metadata (
    val generated: Long,
    val url: String,
    val title: String,
    val status: Long,
    val api: String,
    val count: Long
)
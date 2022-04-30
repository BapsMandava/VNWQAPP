package com.example.vgeqapp.extentions

import java.text.SimpleDateFormat
import java.util.*


fun Long.convertLongToTime(): String {
    val date = Date(this)
    val format = SimpleDateFormat("MMM dd, yyyy HH:mm")
    return format.format(date)
}

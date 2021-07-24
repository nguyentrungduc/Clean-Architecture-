package com.example.cleanarchitecture.extension

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.changeTimeFormat(
    oldFormat: String, newFormat: String, locale: Locale = Locale.getDefault()
): String? {
    if (this.isBlank() || oldFormat.isBlank() || newFormat.isBlank()) {
        return null
    }
    val inputFormat = SimpleDateFormat(oldFormat)
    val outputFormat = SimpleDateFormat(newFormat)
    return try {
        val date = inputFormat.parse(this)
        outputFormat.format(date)
    } catch (e: ParseException) {
        ""
    }
}
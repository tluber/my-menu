package com.acp1.my.menu.utils.extensions

import java.text.SimpleDateFormat
import java.util.*


fun Date.toStringDate(format: String = "yyyy-MM-dd", timezone: TimeZone? = null): String {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    timezone?.apply {
        formatter.timeZone = timezone
    }
    return formatter.format(this)
}

fun String.toDate(format: String = "yyyy-MM-dd", timezone: TimeZone? = null): Date {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    timezone?.apply {
        formatter.timeZone = timezone
    }
    return formatter.parse(this)
}

fun String.toStringDate(
    inputFormat: String = "yyyy-MM-dd",
    outputFormat: String = "yyyy-MM-dd",
    timezone: TimeZone? = null
): String? {

    if (this.isNotEmpty()) {
        try {
            return this.toDate(inputFormat, timezone).toStringDate(outputFormat, timezone)
        } catch (e: Exception) {

        }
    }

    return null
}
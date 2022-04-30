package com.example.sprint.utils

import android.text.TextUtils
import java.time.Instant

fun String.toHour(): String {
    if (!TextUtils.isEmpty(this)) {
        val dt = Instant.now()
        return try {
            return dt.toString("HH:mm")
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
    return ""
}
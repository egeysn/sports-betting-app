package com.example.sprint.utils

import android.text.TextUtils
import org.joda.time.DateTime


fun String.toHour(): String {
    if (!TextUtils.isEmpty(this)) {
        val dt = DateTime()
        return try {
            return dt.toString("HH:mm")
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
    return ""
}
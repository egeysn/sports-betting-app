package com.naylalabs.kotlinbaseproject.utils

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.naylalabs.kotlinbaseproject.BuildConfig
import com.naylalabs.kotlinbaseproject.MainApplication
import java.util.*

class AnalyticsHelper {
    private val mFirebaseAnalytics = Firebase.analytics

    companion object {
        @Volatile
        private var instance: AnalyticsHelper? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: AnalyticsHelper().also { instance = it }
        }
    }

    fun track(eventName: String?, properties: HashMap<String, Any?>) {
        properties.putAll(getBaseProperties())
        logToFirebase(eventName!!, properties)
    }

    fun singleTrack(eventName: String, param: String?, value: Any?) {
        val map = HashMap(getBaseProperties())
        if (param != null) map[param] = value
        logToFirebase(eventName, map)
    }

    private fun logToFirebase(eventName: String, properties: HashMap<String, Any?>) {
        mFirebaseAnalytics.logEvent(eventName, convertHashMapToBundle(properties))
    }

    private fun convertHashMapToBundle(properties: HashMap<String, Any?>): Bundle {
        val bundle = Bundle()
        val keySet = ArrayList(properties.keys)
        for (i in keySet.indices) {
            bundle.putString(keySet[i], properties[keySet[i]].toString())
        }
        return bundle
    }

    private fun getBaseProperties(): HashMap<String, Any?> {
        val map = HashMap<String, Any?>()
        map["OS"] = "android"
        map["versionCode"] = BuildConfig.VERSION_CODE
        map["locale"] = Locale.getDefault().language
        map["device"] = getDeviceId()
        return map
    }

    @SuppressLint("HardwareIds")
    fun getDeviceId(): String? {
        return Settings.Secure.getString(
            MainApplication.appContext.contentResolver,
            Settings.Secure.ANDROID_ID
        )
    }
}

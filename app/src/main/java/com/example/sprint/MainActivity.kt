package com.example.sprint

import android.os.Bundle

import com.google.firebase.messaging.FirebaseMessaging
import com.example.sprint.common.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //For test purposes
        /*    val trackMap = HashMap<String, Any?>()
        trackMap["userName"] = naylalabs"
        trackMap["email"] = "gmail.com"
        AnalyticsHelper.getInstance().track("testEvent",trackMap)*/
    }

    private fun getFcmToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (!it.isSuccessful) {
                return@addOnCompleteListener
            }
            // Get new FCM registration token
            val token = it.result
            if (token != null) {
                cacheHelper.saveFcmToken(token)
            }
        }
    }
}

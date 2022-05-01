package com.example.sprint.utils

import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase


class OddUtilHelper {


    companion object {
        @Volatile
        private var instance: OddUtilHelper? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: OddUtilHelper().also { instance = it }
        }
    }


}

package com.example.sprint.utils

import androidx.lifecycle.MutableLiveData
import com.example.sprint.data.entities.SelectedOddModel
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase


class OddUtilHelper {

    private val selectedOdds: MutableLiveData<ArrayList<SelectedOddModel>> = MutableLiveData()


    fun addSelectedOdd(model: SelectedOddModel) {
        val list = selectedOdds.value
        list?.add(model)
        selectedOdds.postValue(list!!)
    }


    companion object {
        @Volatile
        private var instance: OddUtilHelper? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: OddUtilHelper().also { instance = it }
        }
    }


}

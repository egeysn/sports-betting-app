package com.example.sprint.utils

import androidx.lifecycle.MutableLiveData
import com.example.sprint.data.entities.SelectedOddModel
import timber.log.Timber


class OddUtilHelper {

     val selectedOdds: MutableLiveData<ArrayList<SelectedOddModel>> = MutableLiveData()


    fun addSelectedOdd(model: SelectedOddModel) {
        val list = arrayListOf<SelectedOddModel>()
        if (!selectedOdds.value.isNullOrEmpty()) {
            list.addAll(selectedOdds.value!!)
        }
        list.add(model)
        selectedOdds.postValue(list)
    }

    fun isHaveSelectedOdd(key: String,betId : String): Boolean {
        val list = selectedOdds.value
        return if (list.isNullOrEmpty()) {
            false
        } else {
            val findOdd = list.find { it.marketId == key && it.outCome?.betId == betId }
            Timber.d("isHaveSelectedOdd : $findOdd")
            findOdd != null
        }
    }

    companion object {
        @Volatile
        private var instance: OddUtilHelper? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: OddUtilHelper().also { instance = it }
        }
    }


}

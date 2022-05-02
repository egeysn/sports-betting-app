package com.example.sprint.utils

import androidx.lifecycle.MutableLiveData
import com.example.sprint.data.entities.SelectedOddModel
import timber.log.Timber
import java.util.function.Predicate


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

    fun removeSelectedOdd(id: String) {
        val list = selectedOdds.value
        if (!list.isNullOrEmpty()) {
            for (item in list) {
                if (item.id == id) {
                    list.remove(item)
                }
            }
        }
    }

    fun isHaveSelectedOdd(betId: String): Boolean {
        val list = selectedOdds.value
        return if (list.isNullOrEmpty()) {
            false
        } else {
            val findOdd = list.find { it.outCome?.betId == betId }
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

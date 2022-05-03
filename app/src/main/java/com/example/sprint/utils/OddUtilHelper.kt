package com.example.sprint.utils

import androidx.lifecycle.MutableLiveData
import com.example.sprint.data.entities.SelectedMatchOdd
import timber.log.Timber


class OddUtilHelper {

    val selectedMatchOdds: MutableLiveData<ArrayList<SelectedMatchOdd>> = MutableLiveData()


    fun addSelectedOdd(match: SelectedMatchOdd) {
        val list = arrayListOf<SelectedMatchOdd>()
        if (!selectedMatchOdds.value.isNullOrEmpty()) {
            list.addAll(selectedMatchOdds.value!!)
        }
        list.add(match)
        selectedMatchOdds.postValue(list)
    }

    fun removeSelectedOdd(id: String): Boolean {
        try {
            val list = selectedMatchOdds.value
            if (!list.isNullOrEmpty()) {
                for (item in list) {
                    if (item.id == id) {
                        list.remove(item)
                        selectedMatchOdds.postValue(list!!)
                        break
                    }
                }

            }

        } catch (e: Exception) {
            return false
        }
        return true
    }

    fun isHaveSelectedOdd(betId: String): Boolean {
        val list = selectedMatchOdds.value
        return if (list.isNullOrEmpty()) {
            false
        } else {
            val findOdd = list.find { it.outCome?.id == betId }
            Timber.d("isHaveSelectedOdd : $findOdd")
            findOdd != null
        }
    }

    fun isHaveSelectedMatch(id: String): Boolean {
        val list = selectedMatchOdds.value
        return if (list.isNullOrEmpty()) {
            false
        } else {
            val findOdd = list.find { it.id == id }
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

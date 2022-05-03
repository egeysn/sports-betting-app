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
                        return true
                    }
                }

            }

        } catch (e: Exception) {
            return false
        }
        return false
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

    fun getMaxOdd(): Double {
        var sum = 0.0
        val list = selectedMatchOdds.value
        return if (list.isNullOrEmpty()) {
            sum
        } else {
            list.forEach { sum += it.outCome?.price?.toDouble()!! }
            sum
        }
    }

    fun getMaxPrice(price: Double): Double {
        val maxOdd = getMaxOdd()
        return maxOdd * price
    }

    companion object {
        @Volatile
        private var instance: OddUtilHelper? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: OddUtilHelper().also { instance = it }
        }
    }


}

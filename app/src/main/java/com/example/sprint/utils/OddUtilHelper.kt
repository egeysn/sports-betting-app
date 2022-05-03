package com.example.sprint.utils

import androidx.lifecycle.MutableLiveData
import com.example.sprint.data.entities.SelectedBetMatch
import timber.log.Timber


class OddUtilHelper {

    val selectedBetMatchOdds: MutableLiveData<ArrayList<SelectedBetMatch>> = MutableLiveData()


    fun addSelectedOdd(betMatch: SelectedBetMatch) {
        val list = arrayListOf<SelectedBetMatch>()
        if (!selectedBetMatchOdds.value.isNullOrEmpty()) {
            list.addAll(selectedBetMatchOdds.value!!)
        }
        list.add(betMatch)
        selectedBetMatchOdds.postValue(list)
    }

    fun removeSelectedOdd(id: String): Boolean {
        try {
            val list = selectedBetMatchOdds.value
            if (!list.isNullOrEmpty()) {
                for (item in list) {
                    if (item.id == id) {
                        list.remove(item)
                        selectedBetMatchOdds.postValue(list!!)
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
        val list = selectedBetMatchOdds.value
        return if (list.isNullOrEmpty()) {
            false
        } else {
            val findOdd = list.find { it.betItem?.id == betId }
            Timber.d("isHaveSelectedOdd : $findOdd")
            findOdd != null
        }
    }

    fun isHaveSelectedMatch(id: String): Boolean {
        val list = selectedBetMatchOdds.value
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
        val list = selectedBetMatchOdds.value
        return if (list.isNullOrEmpty()) {
            sum
        } else {
            list.forEach { sum += it.betItem?.price?.toDouble()!! }
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

package com.example.sprint.ui.home.couponFragment


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.entities.OddModel
import com.example.sprint.data.entities.ScoreModel
import com.example.sprint.data.repositories.Repository
import com.example.sprint.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CouponFragmentViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {


    fun fetchFixtures(): LiveData<Resource<ArrayList<OddModel>>> {
        return repository.getOdds("eu","h2h,spreads,totals")
    }


}
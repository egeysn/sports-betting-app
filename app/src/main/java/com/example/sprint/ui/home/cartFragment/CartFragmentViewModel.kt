package com.example.sprint.ui.home.cartFragment


import androidx.lifecycle.LiveData
import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.entities.OddModel
import com.example.sprint.data.repositories.Repository
import com.example.sprint.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {


    fun fetchFixtures(): LiveData<Resource<ArrayList<OddModel>>> {
        return repository.getOdds("eu","h2h,spreads,totals")
    }


}
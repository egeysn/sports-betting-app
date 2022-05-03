package com.naylalabs.scorely.ui.main.home.fixturesFragment


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
class FixturesViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

     val fixtures : MutableLiveData<Resource<ArrayList<OddModel>>> = MutableLiveData()

    fun fetchFixtures(): LiveData<Resource<ArrayList<OddModel>>> {
        val response =  repository.getOdds("eu","h2h,spreads,totals")
        fixtures.postValue(response.value)
        return response
    }


}
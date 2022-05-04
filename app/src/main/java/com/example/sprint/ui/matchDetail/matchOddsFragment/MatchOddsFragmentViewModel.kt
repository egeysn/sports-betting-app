package com.example.sprint.ui.matchDetail.matchOddsFragment


import androidx.lifecycle.MutableLiveData
import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchOddsFragmentViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {


 /*   fun fetchFixtures(): LiveData<Resource<ArrayList<ScoreModel>>> {
        return repository.getScores("soccer_brazil_campeonato", 3)
    }*/


}
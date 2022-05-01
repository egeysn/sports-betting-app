package com.example.sprint.ui.matchDetail.matchDetailsFragment


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.entities.ScoreModel
import com.example.sprint.data.repositories.Repository
import com.example.sprint.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchDetailsFragmentViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

    var page: Int = 0
    private var _date: MutableLiveData<String> = MutableLiveData()

   /* fun fetchFixtures(): LiveData<Resource<ArrayList<ScoreModel>>> {
      //  return repository.getScores("soccer_brazil_campeonato", 3)
    }*/


}
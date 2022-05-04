package com.example.sprint.ui.matchDetail.matchDetailsFragment



import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchDetailsFragmentViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

   /* fun fetchFixtures(): LiveData<Resource<ArrayList<ScoreModel>>> {
      //  return repository.getScores("soccer_brazil_campeonato", 3)
    }*/


}
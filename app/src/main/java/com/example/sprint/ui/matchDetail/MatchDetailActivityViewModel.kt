package com.example.sprint.ui.matchDetail

import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class MatchDetailActivityViewModel @Inject constructor(repository: Repository) :
    BaseViewModel() {
}
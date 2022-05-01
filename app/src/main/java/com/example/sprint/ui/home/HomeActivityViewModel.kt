package com.example.sprint.ui.home

import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class HomeActivityViewModel @Inject constructor(repository: Repository) :
    BaseViewModel() {
}
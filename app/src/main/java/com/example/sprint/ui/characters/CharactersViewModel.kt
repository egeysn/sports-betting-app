package com.example.sprint.ui.characters


import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(repository: Repository) :
    BaseViewModel() {
    val characters = repository.getCharacters()
}
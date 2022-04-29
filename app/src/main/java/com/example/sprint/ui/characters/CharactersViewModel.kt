package com.example.sprint.ui.characters


import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(repository: CharacterRepository) :
    BaseViewModel() {
    val characters = repository.getCharacters()
}
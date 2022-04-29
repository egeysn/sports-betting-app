package com.naylalabs.kotlinbaseproject.ui.characters


import com.naylalabs.kotlinbaseproject.common.BaseViewModel
import com.naylalabs.kotlinbaseproject.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(repository: CharacterRepository) :
    BaseViewModel() {
    val characters = repository.getCharacters()
}
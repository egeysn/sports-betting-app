package com.example.sprint.ui.characterDetail


import com.example.sprint.common.BaseViewModel
import com.example.sprint.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(var repository: CharacterRepository) :
    BaseViewModel() {

    fun getCharacterDetail(id: Int) = repository.getCharacterDetail(id)
}
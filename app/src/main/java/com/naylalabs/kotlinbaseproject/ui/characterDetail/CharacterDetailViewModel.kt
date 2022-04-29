package com.naylalabs.kotlinbaseproject.ui.characterDetail


import com.naylalabs.kotlinbaseproject.common.BaseViewModel
import com.naylalabs.kotlinbaseproject.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(var repository: CharacterRepository) :
    BaseViewModel() {

    fun getCharacterDetail(id: Int) = repository.getCharacterDetail(id)
}
package com.naylalabs.kotlinbaseproject.data.repositories

import com.naylalabs.kotlinbaseproject.common.BaseDataSource
import com.naylalabs.kotlinbaseproject.data.remote.ApiService
import com.naylalabs.kotlinbaseproject.utils.performOperation
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource() {
    fun getCharacters() = performOperation { getResult { apiService.getAllCharacters() } }

    fun getCharacterDetail(id: Int) = performOperation { getResult { apiService.getCharacter(id) } }



}
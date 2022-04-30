package com.example.sprint.data.repositories

import com.example.sprint.common.BaseDataSource
import com.example.sprint.data.remote.ApiService
import com.example.sprint.utils.performOperation
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource() {
    fun getCharacters() = performOperation { getResult { apiService.getAllCharacters() } }

    fun getCharacterDetail(id: Int) = performOperation { getResult { apiService.getCharacter(id) } }



}
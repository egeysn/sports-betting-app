package com.naylalabs.kotlinbaseproject.data.remote


import com.naylalabs.kotlinbaseproject.data.entities.CharacterList
import com.naylalabs.kotlinbaseproject.data.entities.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}
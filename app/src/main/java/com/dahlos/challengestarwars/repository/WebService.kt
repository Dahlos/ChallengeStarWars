package com.dahlos.challengestarwars.repository

import com.dahlos.challengestarwars.data.model.Character
import com.dahlos.challengestarwars.data.model.CharacterList
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("people/{id}")
    suspend fun getCharacter(@Path("id") id: String): Character

    @GET("people/")
    suspend fun getCharacters(): CharacterList
}